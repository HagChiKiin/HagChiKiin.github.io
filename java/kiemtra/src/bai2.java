import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        countText("Con gà gáy o o o  ");

    }

    public static void countText(String text) {
        int count = 0;
        int counto = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i == text.length() - 1) {
                count += 0;
            } else {
                if (text.charAt(i) == ' ') {
                    if (text.charAt(i + 1) == ' ') {
                        count += 0;
                    } else {
                        count++;
                    }
                }
            }

        }
        if (text.charAt(0) == ' ') {
            System.out.println("Số từ trong chuỗi là: " + count);
        } else {
            System.out.println("Số từ trong chuỗi là: " + (count + 1));
        }

        System.out.print("Vị trí ký tự \"o\" trong chuỗi là : ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'o') {
                counto += 1;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Số ký tự \"o\" trong chuỗi là: " + counto);

    }
}

