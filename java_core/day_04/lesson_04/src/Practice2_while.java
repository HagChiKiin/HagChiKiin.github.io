import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;

public class Practice2_while {
    public static void main(String[] args) {
//        Random rd = new Random();
//        int value = rd.nextInt(101);
        double rd = Math.random();
        int value = (int) Math.floor(rd*100);
//        System.out.println(value);
//        boolean isQuit = false;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập vào number :");
            int number = sc.nextInt();
            if(number == value){
                System.out.println(" chúc mừng bạn");
                break;
            } else if (number>value) {
                System.out.println("bạn nhập số lớn hơn rồi");
            }else {
                System.out.println("Bạn nhập số nhỏ hơn rồi");
            }


        }
    }
}
