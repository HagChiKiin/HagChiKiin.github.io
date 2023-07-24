$(document).ready(function () {
    $(".email-reset-form").validate({
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

    $("#submit-reset-modal").click(function (event) {
        let isValidForm = $(".email-reset-form").valid();
        if (!isValidForm) {
            return;
        }
        let formdata = {
            emailReset: $(".email-reset-form #email").val(),
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
                toastr.warning("Email không tồn tại hoặc đã được kích hoạt");
            }
        });
    })

    $('.email-reset-form').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $("#submit-reset-modal").click();
        }
    });
});