package abstract_class;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
abstract public class Employee {
    private int id;
    private String name;
    private int age;
    private int salaryBasic;
    // Điểm danh
    public void register(){
        System.out.println("Register ...");
    }
    // Tính lương
    abstract public int caculateSalary()   ;
    // In thông tin của nhân viên
    abstract void showInfo();
}
