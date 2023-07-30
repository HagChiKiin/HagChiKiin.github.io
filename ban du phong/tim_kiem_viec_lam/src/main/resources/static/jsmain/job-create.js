$(document).ready(function () {
    $("#skill").select2({
        placeholder: "- Chọn chủ đề",
    });

    $(".company-list-inner").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
        },
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "title": {
                required: true,
                maxlength: 255
            },
            "avatar": {
                required: true,
            },
            "salaryFrom": {
                required: true,
                min: 0
            },
            "salaryTo": {
                required: true,
            },
            "dueDateTime": {
                required: true,
            }
        },
        messages: {
            "name": {
                required: "Bắt buộc nhập tên công việc",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "title": {
                required: "Bắt buộc nhập tiêu đề tuyển dụng",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "avatar": {
                required: "Hãy chọn ảnh công việc",
            },
            "salaryFrom": {
                required: "Hãy nhập mức lương từ",
                min: "Mức lương phải lớn hơn hoặc bằng 0"
            },
            "salaryTo": {
                required: "Hãy nhập mức lương đến",
            },
            "dueDateTime": {
                required: "Hãy nhập hạn nộp"
            }
        }
    })
    $('#job-create-btn').click(function () {
        let isValidForm = $(".company-list-inner").valid()
        if (!isValidForm) return

        // Lấy nội dung trong ô input
        let title = $("#title").val();
        let avatar = $("#avatar").val();
        let name = $("#name").val();
        let location = $("#location").val();
        let skill = $("#skill").val();
        let salaryFrom = $("#salaryFrom").val();
        let salaryTo = $("#salaryTo").val();
        let dueDateTime = $("#dueDateTime").val();

        let request = {
            name: name,
            title: title,
            avatar: avatar,
            salaryFrom: salaryFrom,
            salaryTo: salaryTo,
            dueDateTime: dueDateTime,
            location: location,
            skill: skill
        }
        $.ajax({
            url: "/api/v1/jobs",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(request),
            success:
                function (data) {
                    console.log(data)
                    toastr.success("Thêm công việc thành công");
                },
            error: function (data) {
                console.log(data)
                toastr.error("Lỗi khi thêm công việc");
            }
        });
    })
});