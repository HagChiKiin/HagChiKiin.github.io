package program.frontend;

import program.backend.controller.AccountController;
import program.backend.model.Account;
import program.backend.request.ChangeUserNameRequest;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountUI {
    private final AccountController accountController = new AccountController();
    Account  account = new Account();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String passWord = sc.nextLine();
        ArrayList<Account> accounts = accountController.findAll();
        boolean choise = false;
        for (int i = 0; i <accounts.size() ; i++) {
            if(accounts.get(i).getEmail().equals(email) && accounts.get(i).getPassWord().equals(passWord)){
                System.out.println("Chúc mừng " + accounts.get(i).getUserName()+", bạn có thể thực hiện các công việc sau: ");
                choise = true;
            }
        }
        if(!choise){
            System.out.println("Tài khoản hoặc mật khẩu không chính xác");
        }


        while (!isQuit) {
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
                    System.out.println("Nhập vào tên mới");
                    String userName = sc.nextLine();
                    ChangeUserNameRequest request = new ChangeUserNameRequest(userName);
                    Account account = accountController.changeUserName(request);
                    System.out.println(request);


                }
                break;

                case 2: {

                    break;
                }

                case 3: {


                    break;
                }


                case 4: {


                    break;
                }

                case 5: {
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
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát chương trình");
    }
}
