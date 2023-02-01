import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        // Lấy thông tin từ bàn phím
        Scanner sc = new Scanner(System.in);

        int option = 0; //giá trị nhập từ bàn phím
        boolean isQuit = false; // isQuit : cho biết khi nào thì thoát trương trình. khi isQuit = true thì thoát

        while (!isQuit) {  // while true _ thực hiện in  ra  showmenu
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    doFunctionOne();
                    break;
                }
                case 2: {
                    doFunctionTwo();
                    break;
                }
                case 3: {
                    doFunctionThree();
                    break;
                }
                case 4: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }
// các chức năng có trong menu
    public static void doFunctionOne() {
        System.out.println("Thực hiện chức năng 1");
    }

    public static void doFunctionTwo() {
        System.out.println("Thực hiện chức năng 2");
    }

    public static void doFunctionThree() {
        System.out.println("Thực hiện chức năng 3");
    }
// hướng dẫn sử dụng menu
    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Chức năng 1");
        System.out.println("2 - Chức năng 2");
        System.out.println("3 - Chức năng 3");
        System.out.println("4 - Thoát\n");
    }
    }

