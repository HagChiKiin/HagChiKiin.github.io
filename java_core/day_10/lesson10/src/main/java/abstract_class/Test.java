package abstract_class;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Developer(1, "Kiên", 29, 7_800_000, 40);
        System.out.println(employee.caculateSalary());

        Employee employee1 = new Tester(2, "kin", 29, 10_000_000, 10);
        System.out.println(employee1.caculateSalary());

        // Tạo danh sách nhân viên
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(new Developer(3, "Kon", 26, 4_800_000, 30));
        employees.add(new Tester(24, "ken", 21, 15_000_000, 15));
        System.out.println("lương từng nhân viên ");
        for (Employee e : employees
        ) {
            System.out.println(e.caculateSalary());

        }
        //Sắp xếp theo lương giảm dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.caculateSalary() - o1.caculateSalary();
            }
        });
        System.out.println("Lương giảm dần");
        for (Employee e : employees
        ) {
            e.showInfo();

        }
        // Sắp xếp tuổi tăng dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("Sắp xếp tuổi tăng dần ");
        for (Employee e : employees
        ) {
            System.out.println(e.caculateSalary());
        }


        // SỬ dụng stream (Demo)
        // Stream, method reference, lambda expression
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalaryBasic))
                .forEach(Employee::showInfo);
    }
}
