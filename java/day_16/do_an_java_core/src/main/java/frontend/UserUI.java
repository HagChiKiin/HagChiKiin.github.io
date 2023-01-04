package frontend;

import backend.controller.UserController;
import backend.database.UserDB;
import backend.model.User;
import backend.request.Request;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserUI {
    private final UserController userController = new UserController();
    User user = new User();

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
                    studentMenu();
                }
                case 2: {
                    System.out.print("Nhập username mới : ");
                    String userName = sc.nextLine();

                    System.out.print("Nhập email mới : ");
                    String email = sc.nextLine();
                    ArrayList<User> users = userController.findAll();
                    boolean isExists = false;
                    for (User a : users) {
                        if (a.getEmail().equalsIgnoreCase(email)) {
                            isExists = true;
                        }
                    }
                    if (isExists) {
                        System.out.println("Email đã tồn tại!\n");
                    } else {
                        String EMAIL_PATTERN =
                                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

                        if (Pattern.matches(EMAIL_PATTERN, email) == true) {
                            System.out.print("Nhập mật khẩu: ");
                            String passWord = sc.nextLine();
                            if (passWord.length() >= 7 && passWord.length() <= 15) {
                                Request request = new Request(userName, email, passWord);
                                User user1 = user.register(request);
                                System.out.println("Đăng ký thành công!");
                                System.out.println(user1);
                                break;
                            } else {
                                System.out.println("Mật khẩu phải có độ dài từ 7 đến 15 ký tự, hãy nhập lại mật khẩu!");
                            }
                        } else {
                            System.out.println("Email không hợp lệ, hãy nhập lại email!\n");
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.print("Nhập email cần đổi mật khẩu : ");
                    String email = sc.nextLine();
                    ArrayList<User> accounts3 = user.findAll();
                    boolean isExists = false;
                    for (User a : accounts3) {
                        if (a.getEmail().equalsIgnoreCase(email)) {
                            isExists = true;
                        }
                    }
                    if (!isExists) {
                        System.out.println("Email không tồn tại\n");
                    } else {
                        System.out.print("Nhập mật khẩu mới: ");
                        String passWord = sc.nextLine();
                        if (passWord.length() >= 7 && passWord.length() <= 15) {
                            Request request = new Request(passWord, user.getUserName(), user.getEmail());
                            User user2 = userController.forgotPassWord(email, request);
                            System.out.println("Đổi mật khẩu thành công!");
                            System.out.println(user2);
                            break;
                        } else {
                            System.out.println("Mật khẩu phải có độ dài từ 7 đến 15 ký tự!");
                        }
                    }
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

    public void showMenu() {
        System.out.println("\n-----CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ TUYỂN SINH CẤP 3 TRƯỜNG PTTH LIÊN HÀ-----");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Th");
    }
    public void studentMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String passWord = sc.nextLine();
        ArrayList<User> users = AccountDatabase.accounts;
        boolean iXists = false;
        for (User a : users) {
            if (a.getEmail().equals(email) && a.getPassWord().equals(passWord)) {
                System.out.println("Chào mừng " + a.getUserName() + ", bạn có thể thực hiện các công việc sau: ");
                iXists = true;
                boolean isQuit1 = false;
                int option1 = 0;
                while (!isQuit1) {
                    showMenu1();
                    try {
                        System.out.println("Nhập lựa chọn: ");
                        option1 = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Chỉ được lựa chọn từ 1 đến 5\n");
                        continue;
                    }
                    switch (option1) {
                        case 1: {
                        }
                    }
                }
            }
        }
    }
    public void showMenu1() {
        System.out.println("\n-----CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ TUYỂN SINH CẤP 3 TRƯỜNG PTTH LIÊN HÀ-----");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Th");
    }
}