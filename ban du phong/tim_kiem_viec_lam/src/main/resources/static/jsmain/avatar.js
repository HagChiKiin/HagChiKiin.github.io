$(document).ready(function () {
    toastr.options.timeOut = 2500; // 2.5s
    let chosenFile = null;

    $(".change-avatar-btn").click(() => {
        $("#avatar-input").click();
    });

    $("#avatar-input").change(async event => {
        const tempFiles = event.target.files;
        if (!tempFiles || tempFiles.length === 0) {
            return;
        }
        console.log(event.target.files[0].data);
        chosenFile = tempFiles[0];
        $('#imgBase64').val(await toBase64(chosenFile))
        const imageBlob = new Blob([chosenFile], {type: chosenFile.type});
        const imageUrl = URL.createObjectURL(imageBlob);
        $("#avatar").attr("src", imageUrl);
    });

    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = reject;
    });

    $(".submit-avatar-btn").click(() => {
        if (!chosenFile) {
            toastr.error("Chưa chọn file");
            return;
        }

        const formData = new FormData();
        formData.append('avatar', chosenFile);
        $.ajax({
            url: '/api/v1/users/avatar',
            data: formData,
            type: 'POST',
            contentType: false, // NEEDED, DON'T OMIT THIS (requires jQuery 1.6+)
            processData: false, // NEEDED, DON'T OMIT THIS
            success: function (data) {
                $('#imgBase64').val(data)
                console.log(data);
                toastr.success(data);
            },
            error: function (errorData) {
                console.log(errorData);
                toastr.error(errorData);
            }
        });
    });

});