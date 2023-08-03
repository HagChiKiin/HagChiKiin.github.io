function downloadFile(fileName) {
    // Gửi yêu cầu AJAX
    $.ajax({
        url: '/api/v1/files/' + fileName,
        type: 'GET',
        xhrFields: {
            responseType: 'blob'
        },
        success: function(data) {
            // Tạo một đường dẫn tạm thời để tải xuống file
            var url = window.URL.createObjectURL(new Blob([data]));

            // Tạo một thẻ <a> để thực hiện việc tải xuống
            var a = document.createElement('a');
            a.href = url;
            a.download = fileName;
            document.body.appendChild(a);

            // Thực hiện việc tải xuống file bằng cách kích hoạt sự kiện click trên thẻ <a>
            a.click();

            // Xóa đối tượng thẻ <a> đã tạo
            a.remove();

            // Giải phóng URL tạm thời
            window.URL.revokeObjectURL(url);
        },
        error: function() {
            console.error('Failed to download file.');
        }
    });
}