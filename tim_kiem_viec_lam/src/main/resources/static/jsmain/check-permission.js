window.onload = function () {
    const jwtToken = localStorage.getItem("jwtToken");

    if (!jwtToken) {
        // Chưa đăng nhập, chuyển hướng về trang đăng nhập
        window.location.href = "http://localhost:8080/splash";
    } else {
        // lấy ra roles ở dạng string
        const userInfomation = JSON.parse(localStorage.getItem("userInfomation"));
        const userRoles = userInfomation.roles[0];
        console.log(userRoles)


        // Kiểm tra vai trò và chuyển hướng người dùng
        const pathName = window.location.pathname;

        // chỉ admin được vào trang /admin/** ko có role ADMIN chuyển về trang chủ
        if (pathName.startsWith('/admin/') && !userRoles.includes("ADMIN")) {
            window.location.href = "http://localhost:8080";

        // chỉ admin và recruiter được vào trang /recruiter/**  ko có role ADMIN hoặc RECRUITER chuyển về trang chủ
        } else if (pathName.startsWith('/recruiter/') && !userRoles.includes("RECRUITER") && !userRoles.includes("ADMIN")) {
            window.location.href = "http://localhost:8080";
        }
    }
};