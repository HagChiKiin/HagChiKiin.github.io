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
            "email": {
                required: true,
                email: true
            },
        },
        messages: {
            "email": {
                required: "Hãy nhập email của bạn",
                email: "Email không đúng định dạng"
            }
        }
    });

    $("#submit-reset-modal").click(async event => {
        let isValidForm = $(".email-reset-form").valid();
        if (!isValidForm) {
            return;
        }
        let emailReset = $(".email-reset-form #email").val();
        let request = {
            email: emailReset
        };
        console.log(request)

        await $.ajax({
            url: "/api/v1/users/otp-sending",
            type: 'POST',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Vui lòng kiểm tra email");
            },
            error: function () {
                toastr.warning("Email không tồn tại trong hệ thống hoặc chưa kích hoạt");
            }
        });
    })

    // $('.email-reset-form').on('keyup', function (event) {
    //     if (event.key === 'Enter') {
    //         $("#submit-reset-modal").click();
    //     }
    // });
});