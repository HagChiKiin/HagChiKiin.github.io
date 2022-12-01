import java.util.Arrays;
import java.util.Scanner;

public class Practice_Array {
    public static void main(String[] args) {
        System.out.println("Nhập vào phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];

        for (int i = 0; i <array.length ; i++) {
            System.out.println("Nhập phần tử thứ :["+i+"]");
            array[i] = sc.nextInt();
        }
        Arrays.sort(array); // sắp xếp các phẩn tử trong mảng
        System.out.println(Arrays.toString(array));  // in ra kiểu dữ liệu String
        int max = array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        int countEvenNumber = 0;
        int countOddNumber = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] % 2 == 0){
                countEvenNumber++;
            }else {
                countOddNumber++;
            }

        }
        System.out.println("Số phần tử chẵn trong mảng là: " +countEvenNumber);
        System.out.println("Số phần tử chẵn trong mảng là: " +countOddNumber);
        System.out.println("Số lớn nhất của mảng là: " + max);
        System.out.println("Số nhỏ nhất của mảng là: " + min);


    }
}
