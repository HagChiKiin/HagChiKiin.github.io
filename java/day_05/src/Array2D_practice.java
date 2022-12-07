import java.util.Scanner;

public class Array2D_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số dòng :");
        int n = sc.nextInt();
        System.out.println("Nhập số cột :");
        int m = sc.nextInt();
        int[][] array2d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" Nhập phần tử :[" + i + "][" + j + " ]");
                array2d[i][j] = sc.nextInt();

            }
            System.out.println();
        }
        int max = array2d[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < array2d[i][j]) {
                    max = array2d[i][j];
                }

            }

        }
        System.out.println("Phần tử lớn nhất: " + max);
        int max1 = array2d[0][0];
        for (int i = 0; i < n; i++) {
            max1 = array2d[i][0];   // phần tử lớn nhất của các hàng,, đặt giá trị cột về 0.. và ngược lại
            for (int j = 0; j < m; j++) {
                if (max1 < array2d[i][j]) {
                    max1 = array2d[i][j];
                }

            }
            System.out.println(" phần tử lowns nhât của hàng là " + max1);
        }
    }
}
