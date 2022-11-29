import java.util.Scanner;

public class Pratice2_SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 3: {
                System.out.println("Mùa xuân");
                break;
            }
            case 4:
            case 5:
            case 6: {
                System.out.println("Mùa hạ");
                break;
            }
            case 7:
            case 8:
            case 9: {
                System.out.println("Mùa thu");
                break;
            }
            case 10:
            case 11:
            case 12: {
                System.out.println("Mùa đông");
                break;
            }

            default: {
                System.out.println("Không có mùa");
                break;
            }
        }
    }
}
