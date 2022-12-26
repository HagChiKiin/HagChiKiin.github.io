package program.frontend;

import program.backend.controller.AccountController;
import program.backend.model.Account;
import program.backend.request.ChangeRequest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProgramUI {
    AccountController accountController = new AccountController();
    AccountUI accountUI = new AccountUI();

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
                System.out.println("Chỉ được lựa chọn từ 1 đến 3");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập password: ");
                    String passWord = sc.nextLine();
                    ArrayList<Account> accounts1 = accountController.findAll();
                    boolean choise = false;
                    for (Account a : accounts1) {
                        if (a.getEmail().equals(email) && a.getPassWord().equals(passWord)) {
                            System.out.println("Chúc mừng " + a.getUserName() + ", bạn có thể thực hiện các công việc sau: ");
                            choise = true;
                        }
                    }
                    if (!choise) {
                        System.out.println("Tài khoản hoặc mật khẩu không chính xác");
                        break;
                    }
                    AccountUI accountUI = new AccountUI();
                    accountUI.run();
                    break;
                }

                case 2: {
                    System.out.print("Nhập username mới : ");
                    String userName = sc.nextLine();

                    System.out.print("Nhập email mới : ");
                    String email = sc.nextLine();
                    ArrayList<Account> accounts2 = accountController.findAll();
                    boolean isExists = false;
                    for (Account a : accounts2) {
                        if (a.getEmail().equalsIgnoreCase(email)) {
                            isExists = true;
                        }
                    }
                    if (isExists) {
                        System.out.println("Email đã tồn tại!");
                    } else {
                        String EMAIL_PATTERN =
                                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

                        if (Pattern.matches(EMAIL_PATTERN, email)==true) {
                            System.out.print("Nhập mật khẩu: ");
                            String passWord = sc.nextLine();

                            // Kiểm tra độ dài mật khẩu
                            if (passWord.length() >= 7 && passWord.length() <= 15) {
                                ChangeRequest request = new ChangeRequest(userName, email, passWord);
                                Account account = accountController.register(request);
                                System.out.println("Đăng ký thành công!");
                                System.out.println(account);
                            } else {
                                System.out.println("Mật khẩu phải có độ dài từ 7 đến 15 ký tự!");
                            }
                        } else {
                            System.out.println("Email không hợp lệ!\n");
                        }
                    }
                    break;
                }

                case 3: {

                }
                case 4: {

                    break;
                }


                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }




    public void showMenu() {
        System.out.println("\n--------------------MENU-------------------");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
    }

}

