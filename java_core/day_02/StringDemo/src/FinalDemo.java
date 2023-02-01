public class FinalDemo {
    // Khai báo hằng số global
    public static final String EMAIL = "emmangthai.dungkhaianhlabo@gmail.com";

    public static void main(String[] args) {
        final String name = "bob";
        final String FIRST_NAME = "Anna";
        final int NUMBER;
        NUMBER = 10;
        System.out.println(name);
        System.out.println(FIRST_NAME);
        System.out.println(NUMBER);
        System.out.println(EMAIL);
//        NUMBER = 12.. ko thể thay đổi giá trị của hằng số khi đã khai báo
        System.out.println(sumTwoNumber(10,20));
    }

    //Method final thì ko thể overide(ghi đè)
    public static final int sumTwoNumber (int a , int b){
    return a + b;
    }
}
