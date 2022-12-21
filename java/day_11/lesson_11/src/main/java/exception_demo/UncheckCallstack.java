package exception_demo;

public class UncheckCallstack {
    public static void main(String[] args) {
        methodThree();
    }
    public  static void methodOne(){
        System.out.println("One");
        throw new ArithmeticException("Lỗi toán học");

    }
    public static void methodTwo(){
        System.out.println("Two");
        methodOne();
    }
    public static void methodThree() {
        System.out.println("Three");
        try {
            methodTwo();                                    // Xử lý ở phương thức nào cũng được
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

}
