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
    $('#login-employees').click(function () {
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
                localStorage.clear();
                localStorage.setItem('jwtToken', response.jwt);
                localStorage.setItem('refreshToken', response.refreshToken);
                let userInfomation = {
                    username: response.username,
                    userId: response.id,
                    roles: response.roles
                }
                localStorage.setItem('userInfomation', JSON.stringify(userInfomation))
                toastr.success("Đăng nhập thành công");
                setTimeout(function () {
                    if (response.roles[0] === "ADMIN") {
                        window.location.href = 'http://localhost:8080/admin/companies'
                    } else if (response.roles[0] === "USER") {
                        window.location.href = 'http://localhost:8080/'
                    } else {
                        window.location.href = 'http://localhost:8080/recruiter'
                    }
                }, 1000);

            },
            error: function (data) {
                toastr.error("Đăng nhập không thành công!")
            },
        });
    });
    $('#logout-button').click(function () {
        let jwtToken = localStorage.getItem("jwtToken")
        if (jwtToken) {

            $.ajax({
                url: '/api/v1/authentication/logout',
                type: 'POST',
                contentType: 'application/json',
                headers: {
                    'Authorization': 'Bearer' + " " + jwtToken
                },
                success: function () {
                    localStorage.clear()
                    toastr.success("Đăng xuất thành công")

                    setTimeout(function () {
                        window.location.href = 'http://localhost:8080/';
                    }, 1000)
                },
                error: function () {
                    toastr.success("Đăng xuất thất bại")
                }
            })
        } else {
            toastr.warning("Bạn chưa đăng nhập")
        }
    });
})

function refreshToken() {
    let jwt = localStorage.getItem("jwt")
    let refreshToken = localStorage.getItem('refreshToken');
    let formData = {
        refreshToken: refreshToken
    }

    if (!jwt) {
        return
    }
    $.ajax({
        url: '/api/v1/authentication/refresh-token',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        headers: {
            'Authorization': 'Bearer' + " " + jwt
        },
        success: function (response) {
            localStorage.setItem('jwtToken', response.jwt);

        },
        error: function () {
            toastr.error("Token refresh failed");
        }
    });
}

setInterval(refreshToken, 29.5 * 60 * 1000);


