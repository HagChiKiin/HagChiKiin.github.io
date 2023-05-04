package OOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();  // gọi constructor của thằng cha tr xong mới đến thằng con
        Person obj = new Employee();  // cách 2: A obj = new B();  với A à cha và B là con... và obj là Person
        // obj có kiểu là Person nhưng có vùng nhớ là Employee

        //tương tự  ArrayList là con của List ---- upcasting
        List<String> strings = new ArrayList<>();

        //down casting : ép kiểu
        Employee employee1 = (Employee) obj;

        // Trừu tượng
        // abstract và interface
        // interface  : có chung phương thức nhưng khác nhau về thuộc tính...
        // abstract : ví dụ động vât  có khả năng di chuyển... di chuyển như nào thì thằng con mô tả....
    }
}
