$(document).ready(function() {
    $('.reg-form').submit(function(event) {
        event.preventDefault(); // Ngăn chặn form gửi đi khi có lỗi

        // Lấy dữ liệu từ form đăng ký
        var name = $('.reg-form .input-div:nth-child(1) input').val();
        var email = $('.reg-form .input-div:nth-child(2) input').val();
        var phone = $('.reg-form .input-div:nth-child(3) input').val();
        var password = $('.reg-form .input-div:nth-child(4) input').val();

        // Tạo object chứa dữ liệu đăng ký
        var formData = {
            name: name,
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
            success: function(response) {
                console.log(response);
                // Lưu thông tin đăng ký vào localStorage
                localStorage.setItem('name', name);
                localStorage.setItem('email', email);
                localStorage.setItem('phone', phone);
                localStorage.setItem('password', password);

                // Hiển thị thông báo đăng ký thành công
                alert('Đăng ký thành công!');

                // Chuyển hướng đến trang đăng nhập
                window.location.href = '/login-employees';
            },
            error: function(xhr, status, error) {
                console.log(xhr.responseText);
                alert('Đăng ký không thành công. Vui lòng kiểm tra lại thông tin và thử lại.');
            }
        });
    });
});