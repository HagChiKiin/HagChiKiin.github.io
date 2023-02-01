package program.frontend;

import program.backend.controller.AccountController;
import program.backend.database.AccountDatabase;
import program.backend.exception.NotFoundException;
import program.backend.model.Account;
import program.backend.request.ChangeRequest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountUI {
    private final AccountController accountController = new AccountController();
    Account account = new Account();

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
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập password: ");
                    String passWord = sc.nextLine();
                    ArrayList<Account> accounts1 = AccountDatabase.accounts;
                    boolean iXists = false;
                    for (Account a : accounts1) {
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
                                        System.out.println("Nhập vào tên username mới");
                                        String userName = sc.nextLine();
                                        System.out.println("Nhập email của bạn: ");
                                        String email1 = sc.nextLine();
                                        ChangeRequest request = new ChangeRequest(userName);
                                        try {
                                            Account account = accountController.changeUserName(email1, request);
                                            System.out.println("Thay đổi username thành công");
                                            System.out.println(account);

                                        } catch (NotFoundException e) {
                                            {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        ArrayList<Account> accounts = accountController.findAll();
                                        System.out.println("Nhập vào tên email mới");
                                        String newEmail = sc.nextLine();
                                        boolean isExists = false;
                                        for (Account b : accounts
                                        ) {
                                            if (b.getEmail().equalsIgnoreCase(newEmail)) {
                                                isExists = true;
                                            }
                                        }
                                        if (!isExists) {
                                            System.out.println("Nhập email cũ của bạn: ");
                                            String email2 = sc.nextLine();
                                            ChangeRequest request = new ChangeRequest(newEmail, account.getUserName());
                                            try {
                                                Account account = accountController.changeEmail(email2, request);
                                                System.out.println("Thay đổi email thành công");
                                                System.out.println(account);
                                            } catch (NotFoundException e) {
                                                {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                        } else {
                                            System.out.println("Email đã bị trùng, vui lòng nhập lại\n");
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Nhập vào mật khẩu mới ");
                                        String newPassWord = sc.nextLine();
                                        System.out.println("Nhập email của bạn: ");
                                        String email3 = sc.nextLine();
                                        ChangeRequest request = new ChangeRequest(newPassWord, account.getUserName(), account.getEmail());
                                        try {
                                            Account account = accountController.changePassWord(email3, request);
                                            System.out.println("Thay đổi password thành công");
                                            System.out.println(account);
                                        } catch (NotFoundException e) {
                                            {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                    }
                                    case 4: {
                                        isQuit1 = true;
                                        System.out.println("Quay về menu");
                                        break;
                                    }
                                    case 5: {
                                        isQuit1 = true;
                                        isQuit = true;
                                        System.out.println("Tạm biệt các bạn!!!");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Lựa chọn không hợp lệ\n");
                                    }
                                }
                            }
                        }
                    }
                    if (!iXists) {
                        System.out.println("Tài khoản hoặc mật khẩu không chính xác");
                        break;
                    }
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
                        System.out.println("Email đã tồn tại!\n");
                    } else {
                        String EMAIL_PATTERN =
                                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

                        if (Pattern.matches(EMAIL_PATTERN, email) == true) {
                            System.out.print("Nhập mật khẩu: ");
                            String passWord = sc.nextLine();
                            if (passWord.length() >= 7 && passWord.length() <= 15) {
                                ChangeRequest request = new ChangeRequest(userName, email, passWord);
                                Account account = accountController.register(request);
                                System.out.println("Đăng ký thành công!");
                                System.out.println(account);
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
                    ArrayList<Account> accounts3 = accountController.findAll();
                    boolean isExists = false;
                    for (Account a : accounts3) {
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
                            ChangeRequest request = new ChangeRequest(passWord, account.getUserName(), account.getEmail());
                            Account account = accountController.forgotPassWord(email, request);
                            System.out.println("Đổi mật khẩu thành công!");
                            System.out.println(account);
                            System.out.println("Tiến hành đăng nhập lại: ");
                            break;
                        } else {
                            System.out.println("Mật khẩu phải có độ dài từ 7 đến 15 ký tự!");
                        }
                    }
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

    public void showMenu1() {
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát chương trình");
    }


}

