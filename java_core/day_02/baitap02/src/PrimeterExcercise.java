import java.util.Scanner;

public class PrimeterExcercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều rộng : ");
        double w = sc.nextDouble();
        System.out.println("Nhập chiều dài : ");
        double l = sc.nextDouble();

        System.out.println("Chu vi hình chữ nhật : " + ((w + l)*2));
        System.out.println("Diện tích hình chữ nhật : "+ (w * l));
    }

}
