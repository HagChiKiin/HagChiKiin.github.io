import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào chiêu cao");
        double height = input.nextInt();
        System.out.println("Nhập vào cân nặng");
        double weight = input.nextInt();
        System.out.println("Chỉ số BMI ="+ (weight/(height*height)));


    }
}
