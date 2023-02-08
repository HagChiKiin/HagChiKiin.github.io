public class Lc509_DQ {
    public static int fib(int n) { // đệ quy
        //điều kiện dừng
        System.out.println("start n= " + n);
        if (n <= 1) {
            System.out.println("end n = " + n);
            return n;
        }
        //quy nạp
        int Fn = fib(n - 1) + fib(n - 2);
        System.out.println("end n = " + n);
        return Fn;
    }

    public static int fib1(int n) { // đệ quy có nhớ
        int[] arr = new int[31];
        if (arr[n] != 0) {
            return arr[n];
        }
        if (n <= 1) {
            arr[n] = n;
            return n;
        }
        arr[n] = fib(n - 1) + fib(n - 2);
        return arr[n];
    }

    public static int fib2(int n) { // khử đệ quy
        int[] F = new int[31];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));

    }

}
