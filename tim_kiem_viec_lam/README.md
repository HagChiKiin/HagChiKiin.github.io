# Mô tả web JobSeeking

1. Cac roles: Candidate , Recruiter, Admin
2. Chi tiet chuc nang
- Ng dùng không cần đăng nhập tài khoản có thể xem được các Job
+ Các job mới được đăng tuyển gần đây nhất từ các nhà tuyển dụng
+ Các job có mức lương cao 
+ Các job hấp dẫn (Dựa theo số lượng người apply)
+ Có thể tìm kiếm job theo tên job, tên công ty, theo địa điểm, theo skill, theo mức lương tối thiểu, tối đa...
+ Xem được các cty hàng đầu
+ Xem được chi tiết job tuyển dụng( jobdetails) 
+ Trong trang Jobdetails xem được chi tiết tuyển dụng (benefit, requirement, details, location..) ,
có gợi ý các job cùng skill, và có thể xem tất cả job cùng cty tuyển dụng đó
- Ng dùng phải đăng nhập tài khoản mới có thể apply vào 1 job yêu thích nào đó
- Phần security bao gồm: đăng ký, đăng nhập, đăng xuất 
+ Yêu cầu khi đăng ký phải có email đúng định dạng và chưa sử dụng, khi đăng ký thành công sẽ gửi về email link kích hoạt tài khoản
* Khi đăng nhập thành công vs role candidate, ứng viên có thể cập nhật thông tin cá nhân tại trang candidate-info (tên tuổi sdt avatar..)
Ứng viên có thể đổi mật khẩu , hoặc nếu quên mật khẩu thì có thể dùng email mình đã đăng ký để lấy lại, hệ thống sẽ gửi 1đường link để thay đổi mật khẩu về email đó
Khi ứng viên apply vào 1 job yêu thích sẽ hiển thị lên 1 popup cho phép ứng viên điền thông tin các nhân và yêu cầu ứng viên tải CV lên (yêu cầu dạng file PDF)

* Khi đăng nhập thành công vs role Recruiter, bạn là nhà tuyển dụng
- Có thể tạo 1 hay nhiều job tuyển dụng : yêu cầu hạn tuyển dụng là ngày tương lai
- Có thể sửa thông tin job tuyển dụng, và cũng có thể xóa job tuyển dụng nhưng yêu cầu phải khóa lại job đó ( muốn khóa được job thì job phải đã hết ngày tuyển dụng
hoặc đã tuyển đủ ứng viên) - đối với những job đã khóa sẽ ko hiển thị lên web tìm kiếm việc làm
- Nhà tuyển dụng có thể xem được danh sách ứng viên đã ứng tuyển tại 1 job details nào đó mà họ đã đăng tuyển
- Tại trang chi tiết ứng viên ứng tuyển, sẽ có link CV để nhà tuyển dụng xem. Khi click vào CV ứng viên, trạng thái tuyển dụng sẽ từ chưa xem > đã xem, nhà tuyển dụng 
có thể chuyển trạng thái tuyển dụng thành từ chối - khi đó sẽ có 1 thư cảm ơn gửi về mail ứng viên, hoặc có thể chuyển trạng thái thành hẹn phỏng vấn, khi đó sẽ có 1 popup hiển thị lên cho nhà tuyển dụng input vào thời gian và địa điểm phỏng vấn muốn gửi tới ứng viên, và cũng có 1 mail tuyển dụng được gửi tới ứng viên

* Khi đăng nhập với role Admin, bạn là ng quản trị trang web
- Với chế tài bảo vệ ứng viên, khi nhận được những mail gửi đến báo cáo nhà tuyển dụng có dấu hiệu lừa đảo, bạn sẽ có 1 chế tài kiểm tra xác thực độ đúng sai
- Tại trang web tìm kiếm các nhà tuyển dụng, bạn có thể khóa những nhà tuyển dụng khi đã xác thực dấu hiệu lừa đảo. Khi khóa thì tất cả job đã đăng tuyển của nhà tuyển dụng đó sẽ bay mau trên trang web tìm kiếm việc làm






* Cơ chế muốn xây dựng thêm
- Tính năng chat giữa các ứng viên và admin trang web ( yêu cầu phải đăng nhập tài khoản mới chat được)
- Tính năng biểu đồ về số lượng job 
- Tính năng comment, like, thả tim, đánh giá về các job , về các cty tuyển dụng