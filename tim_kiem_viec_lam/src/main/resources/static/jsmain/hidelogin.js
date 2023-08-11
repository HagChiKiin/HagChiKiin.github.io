$(document).ready(function () {
    const userInfomationStr = localStorage.getItem("userInfomation");
    if (userInfomationStr) {
        const userInfomation = JSON.parse(userInfomationStr)
        if (userInfomation.username) {
            $('#registerNavItem').hide();
            $('#loginNavItem').hide();
            $('#loggedInUserNavItem').show();
        }
    }
})