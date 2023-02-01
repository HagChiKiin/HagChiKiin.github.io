public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.ceil(3.11));
        System.out.println(Math.pow(5, 2));
        System.out.println((int) Math.sqrt(25));
        System.out.println(Math.random());
        // công tức tính random  1 số nguyên ( 0 -> n )
        int randomNumber = (int) Math.floor(Math.random() * 100);  //0 > 99
        System.out.println(randomNumber);
        // công thức tính random 1 số nguyên ( n > m )
        int randomNumber1 = (int) Math.floor(Math.random() * (999 - 100 + 1)+100);
        System.out.println(randomNumber1);


    }
}