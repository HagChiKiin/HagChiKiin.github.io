$('.forgot-employees').click(function() {
    var email = $('#email-input').val();

    $.ajax({
        url: '/api/v1/authentication/forgot-password',
        type: 'POST',
        data: JSON.stringify({ email: email }),
        contentType: 'application/json',
        success: function(response) {
            // Xử lý khi yêu cầu quên mật khẩu thành công
            console.log("Yêu cầu quên mật khẩu thành công");
            // Hiển thị thông báo cho người dùng về việc yêu cầu khôi phục mật khẩu đã được gửi (nếu cần)
        },
        error: function(xhr, status, error) {
            // Xử lý khi yêu cầu quên mật khẩu thất bại
            console.log("Yêu cầu quên mật khẩu thất bại");
            // Hiển thị thông báo lỗi cho người dùng (nếu cần)
        }
    });
});