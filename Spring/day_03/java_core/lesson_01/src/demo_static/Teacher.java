package demo_static;

public class Teacher {
    public static  int a = 5;
    static {
        System.out.println("Đây là đoạn code statics ở trong class Teacher");
    }
    public Teacher(){
        System.out.println("Constructor của class teacher");
    }
}
