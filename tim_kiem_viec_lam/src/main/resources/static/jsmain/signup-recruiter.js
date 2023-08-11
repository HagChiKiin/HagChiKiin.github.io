$(document).ready(function () {
    $('.reg-form-recruiter').validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element.parent());
        },
        rules: {
            email: {
                required: true,
                email: true,
            },
            password: {
                required: true,
                minlength: 6,
            },
            confirmPassword: {
                required: true,
                equalTo: "#password",
            },
            contactInfo: {
                required: true,
            },
            phone: {
                required: true,
            },
            name: {
                required: true,
            },
            address: {
                required: true,
            },
            introduce: {
                required: false,
            },
        },
        messages: {
            email: {
                required: "Vui lòng nhập địa chỉ email",
                email: "Vui lòng nhập đúng định dạng email",
            },
            password: {
                required: "Vui lòng nhập mật khẩu",
                minlength: "Mật khẩu phải chứa ít nhất 6 ký tự",
            },
            confirmPassword: {
                required: "Vui lòng nhập lại mật khẩu",
                equalTo: "Mật khẩu nhập lại không khớp",
            },
            contactInfo: {
                required: "Vui lòng nhập website liên hệ",
            },
            phone: {
                required: "Vui lòng nhập số điện thoại liên hệ",
            },
            name: {
                required: "Vui lòng nhập tên công ty",
            },
            address: {
                required: "Vui lòng nhập địa chỉ công ty",
            },
            introduce: {
                required: "Vui lòng nhập giới thiệu",
            },
        },
    });

    let chosenFile = null;

    $("#recruiter-avatar").click(() => {
        $("#avatar-input").click();
    });

    $("#avatar-input").change(event => {
        const tempFiles = event.target.files;
        if (!tempFiles || tempFiles.length === 0) {
            return;
        }
        console.log(event.target.files[0].data);
        chosenFile = tempFiles[0];

        const imageBlob = new Blob([chosenFile], {type: chosenFile.type});
        const imageUrl = URL.createObjectURL(imageBlob);
        $("#recruiter-avatar").attr("src", imageUrl);
    });

    $('#register-recruiter').click(function () {
        let isValidForm = $('.reg-form-recruiter').valid();
        if (!isValidForm) return;

        // Lấy dữ liệu từ form đăng ký
        let email = $('#email').val();
        let password = $('#password').val();
        let confirmPassword = $('#confirmPassword').val();
        let contactInfo = $('#contactInfo').val();
        let phone = $('#phone').val();
        let name = $('#name').val();
        let address = $('#address').val();
        let introduce = $('#introduce').val();

        // Tạo object chứa dữ liệu đăng ký
        let formData = {
            email: email,
            password: password,
            confirmPassword: confirmPassword,
            contactInfo: contactInfo,
            phone: phone,
            name: name,
            address: address,
            introduce: introduce
        };

        var fd = new FormData();
        fd.append('recruiter', JSON.stringify(formData));
        fd.append('avatar', chosenFile);

        // Gửi Ajax request đăng ký
        $.ajax({
            url: '/api/v1/authentication/recruiter-signup',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (response) {
                toastr.success('Đăng Kí Thành Công! Vui lòng truy cập email của bạn và xác thực tài khoản');

                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/login-employers';
                }, 1000)

            },
            error: function (data) {
                toastr.error("Đăng Kí Thất Bại")
            }
        });
    });

});

