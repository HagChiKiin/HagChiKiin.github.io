import java.util.Scanner;

public class Bai_1{
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.println("Nhập vào số a");
     int a = input.nextInt();
     System.out.println("Nhạp vào số b");
     int b = input.nextInt();
     System.out.println("a + b = " + (a+b)); 
     System.out.println("a - b = " + (a-b)); 
     System.out.println("b - a = " + (b-a)); 
     System.out.println("a * b = " + (a*b)); 
     System.out.println("a / b = " + ((double)a/b)); 
     System.out.println("b / a = " + ((double)b/a)); 
    }
    
}