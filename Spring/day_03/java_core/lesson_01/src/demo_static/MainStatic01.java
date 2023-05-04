package demo_static;

public class MainStatic01 {
//    static int AUTO_ID = 10000;
//    int a = 5;
//
//    private static void demo() {         // hàm static chỉ chơi vs biến static
//        System.out.println(AUTO_ID);
//    }
//    private void demoThuong(){           // hàm thường chơi vs tất cả biến và tất cả hàm
//        System.out.println(AUTO_ID);
//
//    }
    public static void main(String[] args) {   // code statics chỉ chạy 1 lần duy nhất và chạy trước constructor
//    Teacher teacher = new Teacher();
//    Teacher teacher1 = new Teacher();
        System.out.println(Teacher.a);   // khi ta đả động tới class đấy thì đoạn code statics sẽ đc gọi
        // ví dụ :
    }
}
