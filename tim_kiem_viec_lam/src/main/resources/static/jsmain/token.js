function refreshToken() {
    const refreshToken = localStorage.getItem('refreshToken');

    if (refreshToken) {
        const requestData = {
            refreshToken: refreshToken
        };

        $.ajax({
            url: '/api/v1/authentication/refresh-token',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function (response) {
                localStorage.setItem('jwtToken', response.jwt);
                localStorage.setItem('refreshToken', response.refreshToken);

                const userInfomation = {
                    username: response.username,
                    userId: response.id,
                    roles: response.roles
                };
                localStorage.setItem('userInfomation', JSON.stringify(userInfomation));

                toastr.success("Token refreshed successfully");
            },
            error: function () {
                toastr.error("Token refresh failed");
            }
        });
    }
}

refreshToken();