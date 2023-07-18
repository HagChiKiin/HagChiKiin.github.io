$(document).ready(function () {

    $(".login-form").validate({
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
            "password": {
                required: true,
                minlength: 6
            }
        },
        messages: {
            "email": {
                required: "Vui lòng nhập email",
                email: "Không đúng định dạng email"
            },
            "password": {
                required: "Vui lòng nhập mật khẩu",
                minlength: "Mật khẩu phải có ít nhất 6 ký tự"
            }
        },
    });

    // sign in
    $('#login-employees').click(function (event) {
        let isValidForm = $(".login-form").valid()
        if (!isValidForm) return

        // Lấy dữ liệu từ form đăng nhập
        var email = $('.input-div.one input').val();
        var password = $('.input-div.pass input').val();

        var formData = {
            email: email,
            password: password
        };

        $.ajax({
            url: '/api/v1/authentication/login',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData),
            success: function (response) {
                localStorage.clear()
                localStorage.setItem('jwtToken', response.jwt)
                localStorage.setItem('refreshToken', response.refreshToken)
                let userInfomation = {
                    username: response.username,
                    userId: response.id,
                    roles: response.roles
                }
                localStorage.setItem('userInfomation', JSON.stringify(userInfomation))
                toastr.success("Đăng nhập thành công");


                if (response.roles[0] === "ADMIN") {
                    window.location.href = 'http://localhost:8080/admin'
                } else if(response.roles[0] === "USER"){
                    window.location.href = 'http://localhost:8080/'
                }else {
                    window.location.href = 'http://localhost:8080/recruiter'
                }
            },
            error: function (data) {
                toastr.error("Đăng nhập không thành công!")
            },
        });
    });

    // Function to update the UI based on the login status
//     function updateUI() {
//         const token = localStorage.getItem('jwtToken');
//         const registerNavItem = $('#registerNavItem');
//         const loginNavItem = $('#loginNavItem');
//         const loggedInUserNavItem = $('#loggedInUserNavItem');
//
//         if (token) {
//             registerNavItem.hide();
//             loginNavItem.hide();
//             loggedInUserNavItem.show();
//         } else {
//             registerNavItem.show();
//             loginNavItem.show();
//             loggedInUserNavItem.hide();
//         }
//     }
//
// // Gọi hàm updateUI khi trang web được tải
//     $(document).ready(function () {
//         updateUI();
//     });

})
