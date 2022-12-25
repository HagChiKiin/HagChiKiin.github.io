package program.frontend;

import program.backend.controller.AccountController;
import program.backend.model.Account;

import java.util.Scanner;

public class ProgramUI {
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
                System.out.println("Chỉ được lựa chọn từ 1 đến 3");
                continue;
            }

            switch (option) {
                case 1: {
                    AccountUI accountUI = new AccountUI();
                    accountUI.run();

                    break;
                }
                case 2: {

                    break;
                }

                case 3: {


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

