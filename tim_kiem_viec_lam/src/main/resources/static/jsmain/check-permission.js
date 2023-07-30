window.onload = function() {
    const jwtToken = localStorage.getItem("jwt");
    const userInfomation = localStorage.getItem("userInfomation");

    // Kiểm tra nếu chưa đăng nhập
    if (!jwtToken || !userInfomation) {
        const pathName = window.location.pathname;
        const isLoginRequiredPage = pathName.startsWith('/ADMIN/') || pathName.startsWith('/RECRUITER/');

        if (isLoginRequiredPage) {
            toastr.success('Vui lòng đăng nhập tài khoản');
            window.location.href = "http://localhost:8080/";
        }
    } else {
        // Đã đăng nhập, kiểm tra quyền truy cập
        const userInfomation = JSON.parse(userInfomation);
        const roles = userInfomation.roles || [];

        // Kiểm tra quyền truy cập tùy theo đường dẫn
        const pathName = window.location.pathname;

        if (pathName.startsWith('/admin/') && !roles.includes("ADMIN")) {
            // Không có quyền truy cập vào trang admin, chuyển hướng đến trang thông báo lỗi
            window.location.href = "http://localhost:8080";
        } else if (pathName.startsWith('/recruiter/') && !roles.includes("RECRUITER")) {
            // Không có quyền truy cập vào trang recruiter, chuyển hướng đến trang thông báo lỗi
            window.location.href = "http://localhost:8080";
        } else {
            // Có quyền truy cập, tiếp tục xử lý khác
            // ...
        }
    }
};

