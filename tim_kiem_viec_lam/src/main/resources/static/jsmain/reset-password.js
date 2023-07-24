$(document).ready(function () {
    $(".forgot-main").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element);
        },
        rules: {
            "password": {
                required: true,
            },
            "re-pass": {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            "password": {
                required: "Enter your password"
            },
            "re-pass": {
                required: "Repeat your password",
                equalTo: "Re-password incorrect"
            }
        }
    });

    $("#reset").click(() => {
        let isValidForm = $("#reset-form").valid();
        if (!isValidForm) {
            return;
        }
        let otpCode = new URLSearchParams(window.location.search).get('otpCode');
        let newPassword = $("#password").val();
        let request = {
            "otpCode": otpCode,
            "newPassword": newPassword
        }
        console.log(request)
        $.ajax({
            url: "/api/v1/users/reset-password",
            type: 'PUT',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Reset password successful!");
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/'
                }, 1000)
            },
            error: function () {
                toastr.warning("Request expired, let resend request!");
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080'
                }, 1500)
            }
        });

    })
})