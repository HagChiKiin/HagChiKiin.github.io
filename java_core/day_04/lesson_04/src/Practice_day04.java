import java.util.Scanner;

public class Practice_day04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    createArray();
                    break;
                }
                case 2: {
                    enterArray();
                    break;
                }
                case 3: {
                    printArray();
                    break;
                }
                case 4: {
                    caculatorArray();
                    break;
                }
                case 5: {
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
    public static void createArray() {
        System.out.println("Nhập vào số phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

    }

    public static void enterArray() {
        System.out.println("Nhập vào số phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ :[" + i + "]");
            array[i] = sc.nextInt();
        }

    }

    public static void printArray() {
        System.out.println("Nhập vào số phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ :[" + i + "]");
            array[i] = sc.nextInt();
        }
        System.out.println("Các phần tử của mảng được nhập là: ");
        for (int i : array) {
            System.out.print(i + " ");
        }


    }
    public static void caculatorArray() {
        System.out.println("Nhập vào số phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ :[" + i + "]");
            array[i] = sc.nextInt();
        }
        System.out.println("Các phần tử của mảng được nhập là: ");
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("\nMảng mới sau khi tăng 1 đơn vị là: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] += 1;
            }
            System.out.print(array[i] + " ");
        }
    }
    // hướng dẫn sử dụng menu
    public static void showMenu() {
        System.out.println("\n\n********* Bài tập 2 *********");
        System.out.println("1 - Tạo mảng số nguyên gồm n phần tử với n nhập từ bàn phím");
        System.out.println("2 - Nhập các phần tử mảng");
        System.out.println("3 - In mảng ra màn hình");
        System.out.println("4 - Thay đổi các phần tử là số chẵn trong mảng lên 1 phần tử");
        System.out.println("5 - Thoát\n");
    }
}




