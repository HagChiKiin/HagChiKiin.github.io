// $(document).ready(function () {
//     $('#logout-button').click(function () {
//         let jwtToken = localStorage.getItem("jwtToken")
//         if (jwtToken) {
//
//             $.ajax({
//                 url: '/api/v1/authentication/logout',
//                 type: 'POST',
//                 contentType: 'application/json',
//                 headers: {
//                     'Authorization': 'Bearer' + " " + jwtToken
//                 },
//                 success: function () {
//                     localStorage.clear()
//                     toastr.success("Đăng xuất thành công")
//
//                     setTimeout(function () {
//                         window.location.href = 'http://localhost:8080/';
//                     }, 1000)
//                 },
//                 error: function () {
//                     toastr.success("Đăng xuất thất bại")
//                 }
//             })
//         } else {
//             toastr.warning("Bạn chưa đăng nhập")
//         }
//     });
//
// })
