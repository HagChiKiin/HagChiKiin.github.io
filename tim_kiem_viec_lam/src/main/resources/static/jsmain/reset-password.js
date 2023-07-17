$(document).ready(function () {
    $(".reset-btn").click(function () {
        // Lấy dữ liệu từ form
        var email = $("input[name='email']").val();
        var otp = $("input[name='otp']").val();
        var password = $("input[name='password']").val();

        // Tạo đối tượng chứa dữ liệu
        var formData = {
            email: email,
            otp: otp,
            password: password
        };

        // Gửi yêu cầu đến máy chủ bằng Ajax
        $.ajax({
            url: '/api/v1/authentication/reset-password',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData),
            success: function (response) {
                // Xử lý kết quả thành công
                toastr.success("Đổi mật khẩu thành công");
                // Chuyển hướng người dùng đến trang chủ hoặc trang đăng nhập
                window.location.href = 'http://localhost:8080';
            },
            error: function (data) {
                // Xử lý lỗi
                toastr.error("Đổi mật khẩu không thành công!");
            },
        });
    });
});