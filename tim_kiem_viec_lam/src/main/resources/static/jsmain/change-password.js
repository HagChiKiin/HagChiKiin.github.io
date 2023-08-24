// Change password
$(document).ready(function () {

    $.validator.addMethod("notEqualTo", function (value, element, param) {
        return this.optional(element) || value !== $(param).val();
    }, "Mật khẩu mới phải khác với mật khẩu hiện tại");

    // Change Password
    $('.change-password-form').validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
        },
        rules: {
            "currentPassword": {
                required: true
            },
            "newPassword": {
                required: true,
                minlength: 6,
                notEqualTo: "#currentPassword"
            },
            "rePassword": {
                required: true,
                equalTo: "#newPassword"
            }
        },
        messages: {
            "currentPassword": {
                required: "Vui lòng nhập mật khẩu hiện tại"
            },
            "newPassword": {
                required: "Vui lòng nhập mật khẩu mới",
                minlength: "Vui lòng nhập ít nhất 6 ký tự",
                notEqualTo: "Mật khẩu mới phải khác với mật khẩu hiện tại"
            },
            "rePassword": {
                required: "Vui lòng nhập lại mật khẩu mới",
                equalTo: "Mật khẩu không khớp"
            }
        },
    })

    $('.change-password-form input').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $('#change-password-btn').click();
        }
    })
    $('#change-password-btn').click(() => {
        let isValidForm = $('.change-password-form').valid();
        if (!isValidForm) {
            return;
        }
        $('#change-password-btn').prop('disabled', true);
        // change password
        let formData = {
            // currentPassword: CryptoJS.MD5($('#currentPassword').val()).toString(),
            // newPassword: CryptoJS.MD5($('#newPassword').val()).toString(),
            // rePassword: CryptoJS.MD5($('#rePassword').val()).toString(),
            currentPassword : $('#currentPassword').val(),
            newPassword : $('#newPassword').val(),
            rePassword : $('#rePassword').val()
        }
        changePassword(formData);
    })

    function changePassword(formData) {
        $.ajax({
            url: "/api/v1/authentication/password-change",
            type: 'PUT',
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function () {
                toastr.success("Đổi mật khẩu thành công");
                setTimeout(function () {
                    $.ajax({
                        url: '/api/v1/authentication/logout',
                        type: 'POST',
                        success: function () {
                            localStorage.clear()
                            window.location.href = 'http://localhost:8080/'
                        },
                        error: function () {
                            toastr.warning("Error network!")
                        }
                    });
                }, 700);

            },
            error: function () {
                toastr.warning("Đổi mật khẩu thất bại");
                $('#change-password-btn').prop('disabled', false);
            }
        })
    }

    // $('#cancel-change-password-btn').click(() => {
    //     $('#change-password-form').validate().resetForm();
    //     $('#current-password').val('');
    //     $('#new-password').val('');
    //     $('#re-password').val('');
    // })
    //
    // $('#show-password').change(function () {
    //     if ($(this).is(':checked')) {
    //         $('#current-password').prop('type', 'text');
    //         $('#new-password').prop('type', 'text');
    //         $('#re-password').prop('type', 'text');
    //     } else {
    //         $('#current-password').prop('type', 'password');
    //         $('#new-password').prop('type', 'password');
    //         $('#re-password').prop('type', 'password');
    //     }
    // })
    //
    // $('#current-password, #new-password, #re-password').on('keyup', function (event) {
    //     if (event.key !== 'Enter') {
    //         $('#change-password-form').validate().resetForm();
    //     }
    // })
})