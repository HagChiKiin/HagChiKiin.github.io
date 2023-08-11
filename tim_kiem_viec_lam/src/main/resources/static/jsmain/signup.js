$(document).ready(function () {
    $('.reg-form-candidate').validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
        },
        rules: {
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6,
            },
            confirmPassword: {
                required: true,
                minlength: 6,
                equalTo: '#password'
            }
        },
        messages: {
            name: {
                required: "Vui lòng nhập họ và tên"
            },
            email: {
                required: "Vui lòng nhập địa chỉ email",
                email: "Email không hợp lệ"
            },
            password: {
                required: "Vui lòng nhập mật khẩu",
                minlength: 'Mật khẩu tối thiểu 6 ký tự',
            },
            confirmPassword: {
                required: 'Vui lòng nhập lại mật khẩu.',
                minlength: 'Mật khẩu tối thiểu 6 ký tự',
                equalTo: 'Mật khẩu không đúng'
            }
        },
    });

    $('#register-employees').click(function () {
        let isValidForm = $('.reg-form-candidate').valid();
        if (!isValidForm) return;

        // Lấy dữ liệu từ form đăng ký
        let email = $('#email').val();
        let password = $('#password').val();


        // Tạo object chứa dữ liệu đăng ký
        let formData = {
            email: email,
            password: password
        };
        // Gửi Ajax request đăng ký
        $.ajax({
            url: '/api/v1/authentication/signup',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData),
            success: function (response) {
                console.log(response);
                toastr.success('Đăng Kí Thành Công! Vui lòng truy cập email của bạn và xác thực tài khoản');

                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/login-employees';
                }, 1000)

            },
            error: function (data) {
                toastr.error("Đăng Kí Thất Bại")
            }
        });
    });

});

