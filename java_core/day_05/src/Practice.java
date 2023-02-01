import java.util.Arrays;
import java.util.Random;

public class Practice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(array1())); // in ra mảng
        System.out.println(repeatString("a"));
        System.out.println(repeatString1("a"));

        System.out.println(checkElementExist(6));
        System.out.println(randomRgbCode());
        System.out.println(randomHexCode());
    }
    public static int[] array1(){
        int [] array = { 4, 5, 8, 9 ,7};
        for (int i = 0; i <array.length ; i++) {
            if(array[i] % 2 ==0){
                array[i]=0;
            }else {
                array[i] =1;
            }

        }
        return array; // trả kq về mảng array
    }
    public static String repeatString(String d){
        String array1[] = new String[10];
        for (int i = 0; i < 10 ; i++) {
            array1[i] = d;
        }
        String text = String.join("",array1); // gộp 1 chuỗi array1 cách nhau bởi delimiter
        return text;  // trả về kq là 1 chuỗi text
    }
    public static String repeatString1(String b){
        String array1[] = new String[10];

        for (int i = 0; i < 10 ; i++) {
            array1[i] = b;
        }
        return String.join("-",array1); // gộp 1 chuỗi array1 cách nhau bởi delimiter
    }
    public static Boolean checkElementExist(int e){
        int [] array2 = {1,2,3,4,5};
        boolean result = false;
        for (int i = 0; i < array2.length ; i++) {
            if( array2[i] == e){
               result = true ;
            }
        }
        return result;
    }
    public  static String randomRgbCode(){
        int [] array= new int[3];
        for (int i = 0; i <3 ; i++) {
            array[i] = (int)(Math.random()*256);
        }
        String text = "Rgb("+ array[0]+","+array[1]+","+array[2]+")"; // tạo chuỗi text = RGB+random 3 số
        return text;

    }
    public static String randomHexCode(){
        String result = "";
        String random = "abcdef123456789";
        for (int i = 0; i < 6; i++) {
            int temp = (int) Math.round(Math.random() * random.length());
            result += random.charAt(temp);
        }
        String result1 = "#" + result;
        return result1;
    }
}
