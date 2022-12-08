import java.util.Scanner;
import java.util.regex.Pattern;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập sdt: ");
        String number = sc.nextLine();
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        System.out.println(email + ": " + Pattern.matches(EMAIL_PATTERN, email));
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        System.out.println(number + ": "+ Pattern.matches(reg , number));
    }
}
