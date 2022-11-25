import java.util.Scanner;

public class MethodDemo {
    public static void main(String[] args) {
        // công việc A : tốn mất 20 dòng code
        // thực hiện cv A 10 lần: tốn 200 dòng code
        // có method: tốn thêm 10 dòng để gọi
        int data = sumTwoNumber( 3, 4);
        System.out.println(data);
        System.out.println(sumTwoNumber(7 , 9));
        sayHello();
        // cách 2: định nghĩa đối tượng > gọi method của đối tượng( thể hiện, instance) đấy
        // Class : khuon banh  chỉ có 1
        // object : bánh sinh ra từ khuôn: có nhiều
        MethodDemo methodDemo = new MethodDemo();
        methodDemo.sayHelloWithName("Kiên Nguyễn");
    }
        // tính tổng 2 số: trả về kết quả là tổng của 2 số
        // tham số : parameter ( giá trị ảo chưa biết trước khi định nghĩa method)
        // Đối sô : argument ( giá trị thật khi thực thi method)
    public static int sumTwoNumber(int a, int b){
        return a + b;

    }
    public static void sayHello() {
        System.out.println("Xin chào các bạn");
    }
    public  void sayHelloWithName(String name) {   //1tham số
        System.out.println("Xin chào " + name);
    }
}