import java.util.Arrays;
import java.util.Scanner;

public class Practice_day04_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        String name = sc.nextLine().toLowerCase();
        String[] strArray = name.split(" ");
        String name1 = "";
        for (int i = 0; i < strArray.length; i++) {
            String name2 = strArray[i];
            name1 = name1 + (name2.substring(0, 1).toUpperCase() + name2.substring(1));
            name1 = name1 + " ";
        }
        System.out.println("After : " +name1);

    }
}