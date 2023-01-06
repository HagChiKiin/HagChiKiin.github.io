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

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String passWord = sc.nextLine();
        ArrayList<User> users = userController.findAll();
        boolean iXists = false;
        for (User a : users) {
            if (a.getEmail().equals(email) && a.getPassWord().equals(passWord)) {
                System.out.println("Chào mừng " + a.getUserName());
                iXists = true;
                while (!isQuit) {
                    showMenu();
                    try {
                        System.out.println("Nhập lựa chọn: ");
                        option = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Chỉ được chọn từ 1 đến 4\n");
                        continue;
                    }
                    switch (option) {
                        case 1: {

                        }
                        case 2: {

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
            if (!iXists) {
                System.out.println("Tài khoản hoặc mật khẩu không chính xác");
                break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n-----Vui lòng chọn các chức năng sau-----");
        System.out.println("1 - Học sinh");
        System.out.println("2 - Admin");
        System.out.println("3 - Thay đổi username");
        System.out.println("4 - Thay đổi mật khẩu");
        System.out.println("5 - Thoát");
    }
}
