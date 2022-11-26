import java.util.Scanner;

public class PracticeScanner01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào a = ");
        int a = sc.nextInt();
        System.out.println("Nhập vào b = ");
        int b = sc.nextInt();

        int sum = a+b;
        int subtraction = a-b;
       int mul = a*b;
        int division = a/b;
       double mu = Math.pow(a,b);
       double division2 = a%b;
//        System.out.println("a + b = "+ sum);  //
//        System.out.println("a - b = "+ subtraction);
//        System.out.println("a * b = "+ mul);
//        System.out.println("a / b = "+ division);
//        System.out.println("a ^ b = "+ mu);
//        System.out.println("a % b = "+ division2);




    }
}
