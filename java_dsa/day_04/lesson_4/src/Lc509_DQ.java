public class Lc509_DQ {
    public static int fib(int n){
        //điều kiện dừng
        System.out.println("start n= "+n);
        if(n<=1){
            System.out.println("end n = "+n);
            return n;
        }
        //quy nạp
        int Fn= fib(n-1) + fib(n-2);
        System.out.println("end n = "+n);
        return Fn;
    }

    public static void main(String[] args) {
        int n =4;
        System.out.println(fib(n));

    }
}
