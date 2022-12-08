public class bai4 {
    public static void main(String[] args) {
        int i=0, count=0;
        int j=0;
        System.out.println("10 số nguyên tố đầu tiên là: ");
        while(count <10) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println("\n" + "Các số nguyên tố nhỏ hơn 10 là: ");
        while(j<10) {
            if (isPrimeNumber(j)) {
                System.out.print(j + " ");
            }
            j++;
        }
    }
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}



