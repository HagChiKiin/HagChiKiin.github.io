$(document).ready(function () {
    $(".login-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        // errorPlacement: function (error, element) {
        //     error.addClass("error-message");
        //     error.insertAfter(element);
        // },
        rules: {
            "email": {
                required: true,
                maxlength: 255
            },
            "password": {
                required: true,
                minlength: 6
            }
        },
        messages: {
            "email": {
                required: "Vui lòng nhập email",
                maxlength: "Email tối đa 255 ký tự"
            },
            "password": {
                required: "Vui lòng nhập mật khẩu",
                minlength: "Mật khẩu phải có ít nhất 6 ký tự"
            }
        },
    });

    // sign in
    $('#login-employees').click(function (event) {
        // event.preventDefault();

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
                toastr.success("Đăng nhập thành công");
                console.log(response)
                localStorage.setItem('email', email);
                localStorage.setItem('password', password);

                window.location.href = '/home';
            },
            error: function (data) {
                toastr.warning(data.responseJSON.message);
                alert('Đăng nhập không thành công. Vui lòng kiểm tra lại email và mật khẩu.');
            }
        });
    });


});