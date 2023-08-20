$(document).ready(function () {
    $(".reset-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
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

    $("#reset-btn").click(() => {
        let isValidForm = $(".reset-form").valid();
        if (!isValidForm) {
            return;
        }
        let otpCode = new URLSearchParams(window.location.search).get('otpCode');
        let newPassword = $("#password").val();
        let request = {
            otpCode: otpCode,
            newPassword: newPassword
        }
        console.log(request)
        $.ajax({
            url: "/api/v1/users/reset-password",
            type: 'PUT',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Đổi mật khẩu thành công");
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/'
                }, 1000)
            },
            error: function () {
                toastr.warning("Đã có lỗi xảy ra");
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/'
                }, 1500)
            }
        });
    })

    $('.reset-form').on('keyup', function (event) {
       if(event.key === 'Enter'){
            $("#reset-btn").click();
        }
    });
})
