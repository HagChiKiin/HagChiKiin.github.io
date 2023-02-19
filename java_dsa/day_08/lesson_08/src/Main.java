public class Main {
    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 20, 30, 40, 45, 46};
        for (int i = 0; i < input.length; i++) {
            int n = input[i];

            System.out.println("input n= " + n);
            long t1 = System.currentTimeMillis();
            long result1 = fib1(n);
            long t2 = System.currentTimeMillis();
            long result2 = fib2(n);
            long t3 = System.currentTimeMillis();

            System.out.println("fib1 result= " + result1 + " | Time= " + (t2 - t1));
            System.out.println("fib2 result= " + result2 + " | Time= " + (t3 - t2));
            System.out.println("---------------------------------------------------");
        }
    }
}
