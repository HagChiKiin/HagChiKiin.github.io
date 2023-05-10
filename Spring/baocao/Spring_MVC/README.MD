    # SPRING MVC
What:   

[MVC] Spring MVC là một framework được thực hiện trong mô hình MVC của các ứng dụng web. Spring MVC Framework có nhiệm vụ cung cấp kiến trúc MVC và các component được sử dụng nhằm phát triển giúp các ứng dụng web được linh hoạt hơn

When: 

- Xây dựng ứng dụng  web ới các tính năng như phân lớp (layering), xử lý yêu cầu HTTP, xử lý mẫu, quản lý trạng thái phiên, điều hướng, tích hợp với các thư viện khác, v.v.

Why: 
- Spring MVC ra đời để thay cho jsb servlet
- Cộng động sử dụng phổ biến
- Các tầng trong spring MVC độc lập nên việc unit test dễ dàng hơn
- Phần view có thể tích hợp với nhiều FramWork về UI như thymeleaf..
- Spring MVC base trên các PoJo class nên hành động của nó khá đơn giản

How

1. Định nghĩa các phụ thuộc cần thiết vào file pom.xml của Maven hoặc Gradle.

2. DispatcherServlet là thành phần trung tâm của Spring MVC, nó sẽ xử lý tất cả các yêu cầu từ client. Thiết lập cấu hình DispatcherServlet trong file web.xml.

3. Thiết lập cấu hình Spring MVC để xác định vị trí lưu trữ các tài nguyên tĩnh, định nghĩa các bean cho các thành phần của Spring MVC như View Resolver, Controllers, và các Validators. Các thông số này được cấu hình trong file applicationContext.xml.

4. Định nghĩa các Controller để xử lý các yêu cầu từ client. Controller là thành phần xử lý các yêu cầu từ client và trả về kết quả cho client. Controller được định nghĩa bằng cách sử dụng các annotation như @Controller, @RequestMapping, @GetMapping, @PostMapping...

5. Xác định để hiển thị kết quả cho client. View được định nghĩa bằng cách sử dụng các template engine như JSP, Thymeleaf, Freemarker...

6. kiểm tra ứng dụng Spring MVC của bạn để đảm bảo rằng nó hoạt động đúng như mong muốn.



