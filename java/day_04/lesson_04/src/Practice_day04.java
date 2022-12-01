import java.util.Scanner;

public class Practice_day04 {
    public static void main(String[] args) {
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
        System.out.println("Nhập vào phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];

        for (int i = 0; i <array.length ; i++) {
            System.out.println("Nhập phần tử thứ :["+i+"]");
            array[i] = sc.nextInt();
        }
        System.out.println("Các phần tử của mảng được nhập là: ");
        for (int i :array ) {
            System.out.print( i + " ");
        }
        System.out.println("\nMảng mới sau khi tăng 1 đơn vị là: ");
        for (int i: array) {
            if(i%2==0){
                 i+=1;
                System.out.print(i+" ");
            }else {
                System.out.print(i+" ");
            }

        }

    }

    public static void doFunctionTwo() {
        System.out.println("Thực hiện chức năng 2");
    }


    // hướng dẫn sử dụng menu
    public static void showMenu() {
        System.out.println("\n\n********* MENU *********");
        System.out.println("1 - Bài tập 1");
        System.out.println("2 - Bài tập 2");
        System.out.println("3 - Thoát\n");
    }
}

