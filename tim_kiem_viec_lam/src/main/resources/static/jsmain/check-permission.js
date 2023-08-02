window.onload = function () {
    const jwtToken = localStorage.getItem("jwtToken");

    if (!jwtToken) {
        // Chưa đăng nhập, chuyển hướng về trang đăng nhập
        window.location.href = "http://localhost:8080/";
    } else {
        const userRoles = ["RECRUITER"]; // Giả định bạn đã lấy thông tin vai trò từ server

        // Kiểm tra vai trò và chuyển hướng người dùng
        const pathName = window.location.pathname;

        if (pathName.startsWith('/admin/') && !userRoles.includes("ADMIN")) {
            window.location.href = "http://localhost:8080";
        } else if (pathName.startsWith('/recruiter/') && !userRoles.includes("RECRUITER")) {
            window.location.href = "http://localhost:8080";
        } else {
            // Có quyền truy cập, tiếp tục xử lý khác
            // ...
        }
    }
};