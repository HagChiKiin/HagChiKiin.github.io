$(document).ready(function () {
    $(".forgot-password-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
        },
        rules: {
            "emailReset": {
                required: true,
                email: true
            },
        },
        messages: {
            "emailReset": {
                required: "Hãy nhập email của bạn",
                email: "Email không đúng định dạng"
            }
        }
    });

    $("#submit-forgot").click(function (event) {
        let isValidForm = $(".forgot-password-form").valid()
        if (!isValidForm) return

        let formdata = {
            emailReset: $("#emailReset").val(),
        };
        $.ajax({
            url: '/api/v1/users/otp-sending',
            type: 'POST',
            data: JSON.stringify(formdata),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Vui lòng check email");
            },
            error: function () {
                toastr.warning("Email không tồn tại hoặc chưa được kích hoạt");
            }
        });
    })

    $('.forgot-password-form').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $("#submit-forgot").click();
        }
    });
});