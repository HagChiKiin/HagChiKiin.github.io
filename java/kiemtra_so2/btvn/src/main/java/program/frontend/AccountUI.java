package program.frontend;

import program.backend.controller.AccountController;
import program.backend.exception.NotFoundException;
import program.backend.model.Account;
import program.backend.request.ChangeRequest;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountUI {
    private final AccountController accountController = new AccountController();
    Account account = new Account();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit1 = false;


        while (!isQuit1) {
            showMenu();
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Chỉ được lựa chọn từ 1 đến 5");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println("Nhập vào tên username mới");
                    String userName = sc.nextLine();
                    System.out.println("Nhập email của bạn: ");
                    String email = sc.nextLine();
                    ChangeRequest request = new ChangeRequest(userName);

                    try {
                        Account account = accountController.changeUserName(email, request);
                        System.out.println("Thay đổi username thành công");
                        System.out.println(account);

                    } catch (NotFoundException e) {
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                break;

                case 2: {
                    ArrayList<Account> accounts = accountController.findAll();
                    System.out.println("Nhập vào tên email mới");
                    String newEmail = sc.nextLine();
                    boolean isExists = false;
                    for (Account a : accounts
                    ) {
                        if (a.getEmail().equalsIgnoreCase(newEmail)) {
                            isExists = true;
                        }
                    }
                    if (!isExists) {
                        System.out.println("Nhập email cũ của bạn: ");
                        String email = sc.nextLine();
                        ChangeRequest request = new ChangeRequest(newEmail, account.getUserName());
                        try {
                            Account account = accountController.changeEmail(email, request);
                            System.out.println("Thay đổi email thành công");
                            System.out.println(account);

                        } catch (NotFoundException e) {
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else {
                        System.out.println("Email đã bị trùng, vui lòng nhập lại");
                    }

                break;
            }

            case 3: {
                System.out.println("Nhập vào mật khẩu mới ");
                String newPassWord = sc.nextLine();
                System.out.println("Nhập email của bạn: ");
                String email = sc.nextLine();
                ChangeRequest request = new ChangeRequest(newPassWord, account.getUserName(), account.getEmail());
                try {
                    Account account = accountController.changePassWord(email, request);
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
                break;
            }

            case 5: {

                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }


}

    public void showMenu() {
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát chương trình");
    }
}
