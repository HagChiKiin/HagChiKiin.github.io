package frontend;

import backend.controller.StudentController;
import backend.controller.UserController;
import backend.model.Student;
import backend.model.Subject;
import backend.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentUI {
    StudentController studentController = new StudentController();
    UserController userController = new UserController();
    Subject subject = new Subject();
    SubjectUI subjectUI = new SubjectUI();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Chỉ được lựa chọn từ 1 đến 3\n");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println("Nhập vào name của bạn");
                    String name = sc.nextLine();
                    System.out.println("Nhập vào id của bạn");
                    int id = Integer.parseInt(sc.nextLine());

                    ArrayList<Student> students =studentController.getStudentById(name,id);
                    if (students.isEmpty()) {
                        System.out.println("Không có học sinh nào tên là: "+ name+ " ,mà có id là : " + id);
                    } else {
                        System.out.println("Thông tin học sinh có id "+ id + " là :");
                        System.out.printf("%-5s %-25s %-15s %-8s %-20s \n", "Id", "Fullname", "Birthday" , "Gender", "Address");
                        for (Student b: students
                        ) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 2: {
                    subjectUI.run();
                    break;

                }
                case 3: {

                }
                case 4: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("\n-----Vui lòng chọn các chức năng sau-----");
        System.out.println("1 - In ra thông tin học sinh ");
        System.out.println("2 - In điểm thi");
        System.out.println("3 - Quay lại");
    }
}
