$(document).ready(function () {
    toastr.options.timeOut = 2500;

    $.validator.addMethod("minDate", function (value, element) {
        var inputDate = new Date(value);
        var currentDate = new Date();
        currentDate.setHours(0, 0, 0, 0);  // Đặt giờ của ngày hiện tại về 00:00:00 để so sánh

        return inputDate >= currentDate;
    }, "Thời gian kết thúc dự kiến không được là ngày quá khứ.");

    $("#task-modal-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "expectedEndTime": {
                required: true,
                date: true,
                minDate: true
            },
            "status": {
                required: true,
            },
            "description": {
                required: true,
                maxlength: 255,
            }
        },
        messages: {
            "name": {
                required: "Bắt buộc nhập tên ",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "expectedEndTime": {
                required: "Bắt buộc nhập thời gian",
                date: "Định dạng ngày tháng phải hợp lệ",
                minDate: "Thời gian kết thúc dự kiến phải là ngày tương lai"
            },
            "quantity": {
                status: "Bắt buộc nhập",
            },
            "description": {
                required: "Bắt buộc nhập mô tả",
                maxlength: "Hãy nhập tối đa 255 ký tự",
            }
        }
    });

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
}