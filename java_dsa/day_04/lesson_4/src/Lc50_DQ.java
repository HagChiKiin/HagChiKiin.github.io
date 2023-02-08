public class Lc50_DQ {
    public static double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            return 1 / pow(x, n);
        }
        return pow(x, n);

    }
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double t = pow(x, n / 2);
        if (n % 2 == 0) {
            return t * t;
        }
        return t * t * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,3));
    }
}
