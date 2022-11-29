import java.util.Scanner;

public class Pratice_Ifelse {
    public static void nhapMark(){
        Scanner sc = new Scanner(System.in);
        int mark = sc.nextInt();
        if( mark >= 85){
            System.out.println("A");
        } else if( mark >=70 && mark < 85){
            System.out.println("B");
        } else if ( mark >=40 && mark<70) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }
    public  static void chiSoBmi(){
        Scanner sc = new Scanner(System.in);
        double h,w,bmi;
        System.out.println("Nhập chiều cao : ");
        h =  sc.nextDouble();
        System.out.println("Nhập cân nặng : ");
        w = sc.nextDouble();
        bmi = w/(h*h);
        System.out.println("bmi : ");

        if( bmi < 18.5){
            System.out.println("Thiếu cân");
        } else if ( bmi <= 24.9) {
            System.out.println("Bình thường");
        } else {
            System.out.println("Thừa cân");
        }
    }
    public static void main(String[] args) {

        nhapMark();
        chiSoBmi();



    }
}
