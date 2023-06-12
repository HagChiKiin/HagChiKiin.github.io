$(document).ready(function () {
    toastr.options.timeOut = 2500;

    $.validator.addMethod("minDate", function (value, element) {
        var inputDate = new Date(value);
        var currentDate = new Date();
        currentDate.setHours(0, 0, 0, 0);  // Đặt giờ của ngày hiện tại về 00:00:00 để so sánh

        return inputDate >= currentDate;
    }, "Thời gian kết thúc dự kiến không được là ngày quá khứ.");

    // validate
    $("#task-modal-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            name: {
                required: true,
                maxlength: 255
            },
            expectedEndTime: {
                required: true,
                date: true,
                minDate: true
            },
            status: {
                required: true
            },
            description: {
                required: true,
                maxlength: 255
            }
        },
        messages: {
            name: {
                required: "Bắt buộc nhập tên.",
                maxlength: "Hãy nhập tối đa 255 ký tự."
            },
            expectedEndTime: {
                required: "Bắt buộc nhập thời gian.",
                date: "Định dạng ngày tháng phải hợp lệ.",
                minDate: "Thời gian kết thúc dự kiến phải là ngày tương lai."
            },
            status: {
                required: "Bắt buộc chọn trạng thái."
            },
            description: {
                required: "Bắt buộc nhập mô tả.",
                maxlength: "Hãy nhập tối đa 255 ký tự."
            }
        }
    });

    // lấy ra trạng thái của task - status
    $.ajax({
        url: "/api/v1/tasks/status",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            const statusSelection = $('#task-modal #status');
            if (statusSelection.children().length === 0) {
                if (!data || data.length === 0) {
                    return;
                }
                let statusOptions = "";
                for (let i = 0; i < data.length; i++) {
                    statusOptions += "<option value='" + data[i].code + "'>" + data[i].name + "</option>";
                }
                statusSelection.append($(statusOptions));
            }
        },
        error: function (data) {
            toastr.warning(data.responseJSON.error);
        }
    });

    //delete button
    $(".delete-btn").click(event => {
        const taskId = $(event.currentTarget).attr("task-id");
        $("#task-delete-confirmation-modal #delete-task").attr("task-id", taskId);
        $("#task-delete-confirmation-modal").modal("show");
    });

    // xóa task
    $("#delete-task").click(event => {
        const taskId = $("#task-delete-confirmation-modal #delete-task").attr("task-id");

        $.ajax({
            url: "/api/v1/tasks/" + taskId,
            type: "DELETE",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Xóa thành công");
                $("#task-delete-confirmation-modal #delete-task").attr("task-id", "");
                $("#task-delete-confirmation-modal").modal("hide");   // xóa và ẩn model
                setTimeout(() => {
                    location.reload();
                }, 500);
            },
            error: function (data) {
                toastr.warning(data.responseJSON.error);
            }
        });
    });

    //create task
    $(".create-task-btn").click((event) => {
        const taskStatus = $(event.currentTarget).attr("task-status");
        $("#task-modal #status").val(taskStatus);
        $("#task-modal #save-task").attr("action-type", "CREATE");

        $("#task-modal").modal("show");
    });

    // open modal to update a task
    $(".task-title").click(async event => {
        const taskId = $(event.currentTarget).attr("task-id");
        let task = null;
        await $.ajax({
            url: "/api/v1/tasks/" + taskId,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                task = data;
            },
            error: function (data) {
                toastr.warning(data.responseJSON.error);
            }
        });

        if (!task) {
            toastr.error("Có lỗi xảy ra, vui lòng thử lại");
            return;
        }
        $("#task-modal-form #name").val(task.name);
        $("#task-modal-form #status").val(task.status);
        $("#task-modal-form #expectedEndTime").val(task.expectedEndTime);
        $("#task-modal-form #description").val(task.description);

        $("#task-modal #save-task").attr("action-type", "UPDATE");
        $("#task-modal #save-task").attr("task-id", taskId);
        $("#task-modal").modal("show");
    });

    // close modal -> clear form + reset form, delete action-type attribute at submit button
    $(".close-modal").click(() => {
        $("#task-modal #save-task").attr("action-type", "");
        $("#task-modal #save-task").attr("task-id", "");
        $('#task-modal-form').trigger("reset");
    });
    // create or update a task
    $("#save-task").click(async event => {
        const isValidForm = $("#task-modal-form").valid();
        if (!isValidForm) {
            return;
        }

        const actionType = $(event.currentTarget).attr("action-type");
        const taskId = $(event.currentTarget).attr("task-id");
        const formData = $('#task-modal-form').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestBody = {};
        for (let i = 0; i < formData.length; i++) {
            requestBody[formData[i].name] = formData[i].value;
        }

        const method = actionType === "CREATE" ? "POST" : "PUT";
        if (method === "PUT") {
            requestBody["id"] = taskId;
        }
        await $.ajax({
            url: "/api/v1/tasks",
            type: method,
            data: JSON.stringify(requestBody),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success((actionType === "CREATE" ? "Create" : "Update") + " a new task successfully");
                $(event.currentTarget).attr("action-type", "");
                $("#task-modal").modal("hide");
                setTimeout(() => {
                    location.reload();
                }, 500);
            },
            error: function (data) {
                toastr.warning(data.responseJSON.error);
            }
        });

        $("#task-modal #save-task").attr("action-type", "");
        $("#task-modal #save-task").attr("task-id", "");
        $('#task-modal-form').trigger("reset");
    });

});

function dragStart(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}

function dropHandler(event) {
    event.preventDefault();
    const id = event.dataTransfer.getData("text");
    const taskId = id.split("-")[1];
    const targetStatus = event.target.getAttribute("task-status");
    $.ajax({
        url: "/api/v1/tasks/" + taskId + "/" + targetStatus,
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            event.target.appendChild(document.getElementById(id));
            toastr.success("Change status successfully");
        },
        error: function (data) {
            toastr.warning(data.responseJSON.error);
        }
    });
}