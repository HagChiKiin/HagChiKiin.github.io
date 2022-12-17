package practice1.controller;

import practice1.database.EmployeeDatabase;
import practice1.model.Employee;
import practice1.repository.EmployeeRepository;
import practice1.service.EmployeeService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static practice1.database.EmployeeDatabase.employee;

public class EmployeeController {
    public EmployeeService employeeService =new EmployeeService();
    public  void run(){
        Scanner sc = new Scanner(System.in);
        int option = 0 ;
        boolean isQuit = false;
        while (!isQuit){
            showMenu();
            System.out.println("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    System.out.println("Hiển thị thông tin nhân viên: ");
                    employeeService.printEmployee();
                    break;

                }
                case 2:{
                    System.out.println("Thêm id : ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Thêm tên : ");
                    String name = sc.nextLine();
                    System.out.println("Thêm email : ");
                    String email = sc.nextLine();
                    System.out.println("Thêm salary : ");
                    int salary = Integer.parseInt(sc.nextLine());
                    Employee employee = new Employee(id,name, email,salary);
                    System.out.println("Tổng số nhân viên sau khi thêm là: ");
                    employeeService.printaddEmployee(employee);
                    break;
                }
                case 3:{
                    System.out.print("Nhập tên cần tìm : ");
                    String name = sc.nextLine();
                    employeeService.printfindByName(name);
                    break;
                }
                case 4:{
                    System.out.println("Nhập id cần tìm: ");
                    int id = Integer.parseInt(sc.nextLine());
                    employeeService.printfindbyId(id);

                }
                case 5:{
                    System.out.println("Nhập id nhân viên cần xóa");
                    int id = Integer.parseInt(sc.nextLine());
                    employeeService.printdeletebyId(id);
                    break;
                }
                case 6:{
                    System.out.println("Nhân viên có mức lương 5000000 đến 10000000 là: ");
                    employeeService.printfindbySalary();
                    break;
                }

                case 7:{
                    isQuit =  true;
                    System.out.println("Good bye");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }

    }

}
    public static void showMenu(){
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Hiển thị thông tin nhân viên");
        System.out.println("2 - Thêm nhân viên mới");
        System.out.println("3 - Tìm kiếm nhân viên theo name");
        System.out.println("4 - Tìm kiếm nhân viên theo id");
        System.out.println("5 - Xóa kiếm nhân viên theo id");
        System.out.println("6 - Tìm kiếm nhân viên theo lương");
        System.out.println("7 - Thoát\n");
    }
}
