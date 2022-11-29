import java.util.Scanner;

public class Pratice1_SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day =  sc.nextInt();
        switch (day) {
            case 0: {
                System.out.println("Hôm nay là chủ nhật");
                break;
            }
            case 1: {
                System.out.println("Hôm nay là thứ 2");
                break;
            }
            case 2: {
                System.out.println("Hôm nay là thứ 3");
                break;
            }
            case 3: {
                System.out.println("Hôm nay là thứ 4");
                break;
            }
            case 4: {
                System.out.println("Hôm nay là thứ 5");
                break;
            }
            case 5: {
                System.out.println("Hôm nay là thứ 6");
                break;
            }
            case 6: {
                System.out.println("Hôm nay là thứ 7");
                break;
            }
            default: {
                System.out.println("Không có thứ");
                break;
            }
        }
    }
}
