package practice_constructor;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Kiên",29,"Đông anh",150);

        employee.printInfo();
        System.out.println(employee.getSalary());

    }
}
