import java.util.Scanner;

public class Practice_For {
    public static void main(String[] args) {

      System.out.println(repeatString1("a"));;  // bài 1
      System.out.println(repeatString2("a"));   // bài 2
      System.out.println(repeatString3("a",5)); // bài 3
      System.out.println(sumCaculator());   // bài 4
      System.out.println(sphericalVolumer(5));  // bài 5
      number(); // bài 6
    }
    // Bài 1
    public static String repeatString1(String text){
        String text1= "";
        for (int i = 1; i <= 10; i++){
            text1 += text;
        }
        return text1;
    }
    // Bài 2
    public static String repeatString2(String text) {
        String text2 = "";
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                text2 += text + "-";
            } else {
                text2 += text;
            }
        }
        return text2;
    }
    // Bài 3
    public static String repeatString3(String text, int n) {
        String text3 = "";

        for (int i = 1; i <= n; i++) {
            if (i < n) {
                text3 += text + "-";
            } else {
                text3 += text;
            }
        }
        return text3;
    }
    // Bài 4
    public static int sumCaculator(){
        int sum = 0;
        for(int i = 0; i <=100 ; i++){
            if(i % 5 ==0){
                sum +=i;
            }
        }
            return sum;
    }
    // Bài 5
    public static double sphericalVolumer(double r) {
        double volumer;
        volumer = Math.pow(r,3) * Math.PI * 4/3;
        return volumer;
    }
    // Bài 6
    public static void number(){
        for (int i = 1; i <= 100 ; i++) {
            if( i % 3 == 0 && i % 5 !=0 ){
                System.out.println("Fizz");
            } else if ( i % 5 == 0 && i % 3 !=0) {
                System.out.println("Buzz");
            } else if ( i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }else {
                System.out.println(i);
            }
        }
    }
}

