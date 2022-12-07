import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int[][] number1 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < number1.length; i++) {
            System.out.println(Arrays.toString(number1[i]));

            for (int j = 0; j < number1[i].length; j++) {
                System.out.println(number1[i][j]);
            }
        }
        // sử dụng for each
        System.out.println("Sử dụng for each: ");
        for (int[] row : number1) {   // for(tên random : biến giá trị tước)
            for (int numbers : row) {
                System.out.println(numbers);

            }

        }


    // giá sách
//        1 chiều: lặp qua từng quyển sách;
//        2 chiều: lặp qua từng quyển sách, mỗi quyển lặp qua từng trang
//        3 chiều: lặp qua từng quyển sách, mỗi quyển lặp qua từng trang, mỗi trang lặp qua từng dòng
    Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int row= sc.nextInt();
        System.out.println("Nhạp vào số cột: ");
        int col= sc.nextInt();

        int[][] array = new int [row][col];
        // Nhập thông tin mảng
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.printf("Nhập vào phần tử [%d][%d] ", i,j);
                array[i][j] = sc.nextInt();
            }
        }
        // In ra mảng ở dạng ma trận
        for (int[] subArray: array) {
            for (int number2 : subArray) {
                System.out.print(number2 + " " );// in hàng 1
            }
            System.out.println();// xuống dòng
        }
    }
}


