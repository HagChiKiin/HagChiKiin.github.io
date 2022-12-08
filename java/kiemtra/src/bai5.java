import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số dòng :");
        int n = sc.nextInt();
        System.out.println("Nhập số cột :");
        int m = sc.nextInt();
        int[][] array2d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" Nhập phần tử mảng 1:[" + i + "][" + j + "]");
                array2d[i][j] = sc.nextInt();

            }
            System.out.println();
        }
        System.out.println("Mảng 1 vừa nhập là :");
        for (int[] subArray : array2d) {
            for (int number2 : subArray) {
                System.out.print(number2 + " ");// in hàng 1
            }
            System.out.println();// xuống dòng
        }
        System.out.println("Các phần tử của đường chéo chính là: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(array2d[i][j] + " ");
                }
            }
        }
        System.out.println();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" Nhập phần tử mảng 2:[" + i + "][" + j + "]");
                array[i][j] = sc.nextInt();
            }
        }
        int [][] sumArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumArray[i][j] = array2d[i][j] + array[i][j];
            }
        }

        System.out.print("Mảng sau khi công là: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(sumArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}