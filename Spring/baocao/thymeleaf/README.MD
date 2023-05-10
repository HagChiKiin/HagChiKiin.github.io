    # Thymeleaf
What:  

    Thymeleaf là một engine template (mô-đun xử lý mẫu) dùng để xử lý các file template HTML hoặc XML.

When:

    Thymeleaf được sử dụng trong các ứng dụng web Java nếu muốn tạo các trang web động với các giá trị được lấy từ dữ liệu của ứng dụng, ví dụ như hiển thị danh sách, biểu mẫu, hoặc bất kỳ dữ liệu nào khác mà muốn hiển thị trên trang web. Nó cũng hỗ trợ nhiều tính năng như kế thừa mẫu, thư viện và điều hướng.

  Why:

1. Thymeleaf tích hợp tốt với Spring Framework, đặc biệt là Spring MVC. Điều này cho phép lập trình viên dễ dàng tích hợp các template Thymeleaf vào các ứng dụng Spring.

2. Thymeleaf cung cấp một cú pháp đơn giản và dễ đọc, cho phép lập trình viên tạo các template dễ dàng và hiệu quả.

3. Thymeleaf cho phép lập trình viên tạo các template được tối ưu hóa cho SEO bằng cách tạo các thẻ HTML tương ứng với các đối tượng dữ liệu được hiển thị.

4. Thymeleaf cung cấp các tính năng mạnh mẽ như việc sử dụng các biểu thức SpEL để xử lý dữ liệu và tích hợp với các thư viện khác để đáp ứng các yêu cầu khác nhau của ứng dụng web.-

How

1. Thêm dependency cho Thymeleaf vào file pom.xml (hoặc build file tương ứng nếu dự án không phải là Maven):

2. Thêm cấu hình cho Thymeleaf trong file application.properties (hoặc file cấu hình tương ứng):

3. Tạo các file template Thymeleaf với đuôi .html. Bạn có thể sử dụng Thymeleaf để hiển thị dữ liệu động, binding dữ liệu với HTML, lặp qua danh sách, thực hiện điều kiện logic, v.v.

4. Trong Spring, để sử dụng Thymeleaf làm công cụ view,  cần tạo một @Controller hoặc một @RestController để điều hướng và trả về dữ liệu cho Thymeleaf. Thông thường,  sẽ trả về tên file template Thymeleaf, ví dụ:
        
        @Controller
        public class MyController {

        @GetMapping("/my-page")
   
        public String myPage(Model model) {
   
         model.addAttribute("name", "Thymeleaf");
   
         return "my-page-template";
            }
        }
   
5. Thực hiện cấu hình template resolver để Thymeleaf có thể tìm và render các file template. (Trong Spring Boot, cấu hình này sẽ được tự động thực hiện)