package exception_demo;

public class Handle {
    public static void main(String[] args) {
        try{
            methodOne();
            methodTwo();
        } catch (ArithmeticException  | NullPointerException e ){
            System.out.println("Lỗi rồi xử lý đi");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Luôn luôn được thực hiện 1 lần");
        }
//         catch (NullPointerException e){
//            System.out.println("Xử lý lỗi Nullpointer");
//        }
        System.out.println("Code continue...");
    }

    public static void methodOne(){
        int number = 9 ;
        int zero = 1;
        int result = number/zero;
        System.out.println(result);
    }

    public static void methodTwo(){
        String str = "abc";
        System.out.println(str.length()); //NullPointerException
    }
}
