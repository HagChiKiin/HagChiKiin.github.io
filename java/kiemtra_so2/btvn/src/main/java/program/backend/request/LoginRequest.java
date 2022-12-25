package program.backend.request;

public class LoginRequest {
    private String email;
    private String passWord;
    public static  String REGEX_EMAIL  =
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//    String EMAIL_PATTERN =
//            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//        System.out.println("email - "+email + ": " + Pattern.matches(EMAIL_PATTERN, email));
    public static final String REGEX_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{7,15}$";
//    Regex này sẽ thực thi các quy tắc sau:
//
//    Ít nhất một chữ cái viết hoa tiếng Anh ,(?=.*?[A-Z])
//    Ít nhất một chữ cái tiếng Anh viết thường, (?=.*?[a-z])
//    Ít nhất một chữ số, (?=.*?[0-9])
//    Ít nhất một nhân vật đặc biệt, (?=.*?[#?!@$%^&*-])
//    Chiều dài {7,15}(với các neo)
}
