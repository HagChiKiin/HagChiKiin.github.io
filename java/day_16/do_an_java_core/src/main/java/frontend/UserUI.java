package frontend;

import backend.controller.UserController;
import backend.database.UserDB;
import backend.exception.NotFoundException;

import java.io.Console;

import backend.model.User;
import backend.request.ChangePassword;
import backend.request.ChangeUsername;
import backend.request.CreateUser;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserUI {
    private final UserController userController = new UserController();
    User user = new User();
    StudentUI studentUI = new StudentUI();

    // Method menu chính - menu 1
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
                System.out.println("Chỉ được lựa chọn từ 1 đến 4\n");
                continue;
            }
            switch (option) {
                case 1: {
                    run1();

                    break;
                }
                case 2: {
                    register();
                    break;
                }

                case 3: {
                    forgotPassword();
                    break;
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

    // In ra Menu 1
    public void showMenu() {
        System.out.println("\n-----CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ TUYỂN SINH CẤP 3 TRƯỜNG PTTH LIÊN HÀ-----");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát");
    }

    // Method đăng ký username, email, password mới
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập username mới : ");
        String newUserName = sc.nextLine();
        newUserName = newUserName.replaceAll(" ", "");
        ArrayList<User> users1 = userController.findAll();
        // Không cho tạo mới username trùng tên admin
        if (!newUserName.equalsIgnoreCase("admin")) {
            System.out.print("Nhập email mới : ");
            String newEmail = sc.nextLine();
            boolean isExists = false;
            for (User b : users1) {
                // Kiểm tra trùng email trong file json
                if (b.getEmail().equalsIgnoreCase(newEmail)) {
                    isExists = true;
                }
            }
            if (isExists) {
                System.out.println("Email đã tồn tại!\n");
            } else {
                // Kiểm tra định dạng email
                String EMAIL_PATTERN =
                        "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

                if (Pattern.matches(EMAIL_PATTERN, newEmail) == true) {
                    System.out.print("Nhập mật khẩu mới: ");
                    String newPassword = sc.nextLine();
                    // Kiểm tra điều kiện password >= 8 ký ự
                    if (newPassword.length() >= 8) {
                        CreateUser rq = new CreateUser(newUserName, newEmail, newPassword);
                        try {
                            User user1 = userController.register(rq);
                            System.out.println("Đăng ký thành công!");
                            System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                            System.out.println(user1);
                        } catch (NotFoundException e) {
                            {
                                System.out.println(e.getMessage());
                            }
                        }

                    } else {
                        System.out.println("Mật khẩu phải có độ dài từ 8 ký tự trở lên, hãy nhập lại mật khẩu!");
                    }
                } else {
                    System.out.println("Email không hợp lệ, hãy nhập lại email!\n");
                }
            }
        } else {
            System.out.println("Không được tạo username trùng với admin");
        }

    }

    // Method quên mật khẩu
    private void forgotPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập email cần đổi mật khẩu : ");
        String email = sc.nextLine();
        ArrayList<User> users2 = userController.findAll();
        boolean isExists = false;
        for (User a : users2) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                isExists = true;
            }
        }
        if (!isExists) {
            System.out.println("Email không tồn tại\n");
        } else {
            System.out.print("Nhập mật khẩu mới: ");
            String newPassword = sc.nextLine();
            if (newPassword.length() >= 8) {
                ChangePassword rq = new ChangePassword(newPassword);
                try {
                    User user3 = userController.forgotPassWord(email, rq);
                    System.out.println("Đổi mật khẩu thành công!");
                    System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                    System.out.println(user3);
                } catch (NotFoundException e) {
                    {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("Mật khẩu phải có độ dài từ 7 đến 15 ký tự!");
            }
        }
    }

    // Method menu 2
    public void run1() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit1 = false;
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String passWord = sc.nextLine();
        ArrayList<User> users = UserDB.users;
        boolean iXists = false;
        for (User a : users) {
            // Sau khi đăng nhập thành công thì thực hiên tiếp các chức năng
            if (a.getEmail().equalsIgnoreCase(email) && a.getPassWord().equalsIgnoreCase((passWord))) {
                System.out.println("Chào mừng " + a.getUserName());
                iXists = true;
                while (!isQuit1) {
                    showMenu1();
                    try {
                        System.out.println("Nhập lựa chọn: ");
                        option = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Chỉ được chọn từ 1 đến 4\n");
                        continue;
                    }
                    switch (option) {
                        case 1: {
                            if(!a.getUserName().equalsIgnoreCase("admin")){
                                studentUI.run();
                            }else {
                                System.out.println("Vui lòng chọn phần admin");
                            }
                            break;
                        }
                        case 2: {
                            if (a.getUserName().equalsIgnoreCase("admin")) {
                                studentUI.run1();
                            } else {
                                // Username phải là admin mới chọn được chức năng 2
                                System.out.println("không đủ thẩm quyền, vui lòng phần học sinh");
                                isQuit1 = true;
                                break;
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Nhập email của bạn");
                            String email1 = sc.nextLine();
                            System.out.println("Nhập vào username mới:  ");
                            String newUsername = sc.nextLine();
                            ChangeUsername request = new ChangeUsername(newUsername);
                            try {
                                // changeUsername - method đổi tên username dựa trên email của tài khoản
                                User user1 = userController.changeUsername(email1, request);
                                System.out.println("Thông tin sách sau khi thay đổi là: ");
                                System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                                System.out.println(user1);
                                // Xử lý lỗi notfoundException
                            } catch (NotFoundException e) {
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        }
                        case 4: {
                            isQuit1 = true;
                            break;
                        }
                        default: {
                            System.out.println("Lựa chọn không hợp lệ");
                        }
                    }
                }
            }
        }
        if (!iXists) {
            System.out.println("Tài khoản hoặc mật khẩu không chính xác");

        }
    }

    // In ra menu2
    public void showMenu1() {
        System.out.println("\n-----Vui lòng chọn các chức năng sau-----");
        System.out.println("1 - Học sinh");
        System.out.println("2 - Admin");
        System.out.println("3 - Thay đổi username");
        System.out.println("4 - Thoát");
    }
}