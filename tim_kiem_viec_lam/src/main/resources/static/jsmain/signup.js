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
            fullname: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true
            },
            password: {
                required: true
            },
            // rePassword: {
            //     required: true,
            //     equalTo : '#password'
            // }
        },
        messages: {
            fullname: {
                required: "Vui lòng nhập họ và tên"
            },
            email: {
                required: "Vui lòng nhập địa chỉ email",
                email: "Email không hợp lệ"
            },
            phone: {
                required: "Vui lòng nhập số điện thoại"
            },
            password: {
                required: "Vui lòng nhập mật khẩu"
            },
            // rePassword: {
            //     required: "Vui lòng nhập lại mật khẩu"
            // }
        },
    });
    $('#register-employees').click(function (event) {
        let isValidForm = $('.reg-form-candidate').valid()
        if (!isValidForm) return

        // Lấy dữ liệu từ form đăng ký
        var fullname = $('#fullname').val();
        var email = $('#email').val();
        var phone = $('#phone').val();
        var password = $('#password').val();


        // Tạo object chứa dữ liệu đăng ký
        var formData = {
            fullname: fullname,
            email: email,
            phone: phone,
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

                window.location.href = '/login-employees';
            },
            error: function (data) {
                toastr.error("Đăng Kí Thất Bại")
            }
        });
    });
});

// Hàm để thực hiện xác thực người dùng khi tải trang
function checkLoggedIn() {
    const jwtToken = localStorage.getItem("jwtToken")
    if (!jwtToken) {
        $("#avatar_toggle").empty();
        const loginHtmlContent = "<span>Login</span>";
        $("#avatar_toggle").append(loginHtmlContent);
        return;
    }
    const userInfo = JSON.parse(localStorage.getItem("userInfomation"));
    $(".avatar_toggle").empty();
    const userHtmlContent = "<span>" + userInfo.email + "</span>";
    $(".avatar_toggle").append(userHtmlContent);
}
checkLoggedIn();

// function showAvatar() {
//     const avatarElement = document.querySelector('.avatar');
//     avatarElement.style.display = 'block';
//
//     const loginRegisterElement = document.querySelectorAll('.user-partner');
//     loginRegisterElement.forEach(element => {
//         element.style.display = 'none';
//     })
// }

