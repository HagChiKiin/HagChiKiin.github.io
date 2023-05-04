package demo_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        // nhập mảng
        System.out.println("Nhập số lượng phần tử: ");
        int n = new Scanner(System.in).nextInt();

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ "+(i+1)+" : ");
            arr[i] = new Scanner(System.in).nextInt();
        }

        System.out.println(Arrays.toString(arr));


        // sắp xếp   nổi bọt
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // in kết quả
        System.out.println(Arrays.toString(arr));
    }
}
