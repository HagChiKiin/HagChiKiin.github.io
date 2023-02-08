import java.sql.SQLOutput;

public class Main {
    private static void printF(int n) {
        // Điều kiện dừng của đệ quy
        if (n > 5) {
            return;
        }
        //công thức truy hồi, quy nạp
        System.out.println("start: n = " + n);
        printF(n + 1); // xong khi n = 5
        System.out.println("end: n = " + n);
    }

    private static int factorial(int n) {
        // điều kiện cơ sở, điều kiện đúng
        // điểm nao
        System.out.println("start n= "+n);
        if (n == 0) {
            System.out.println("end n= " + n);
            return 1;
        }
        // công thức quy nạp. công tức tổng quat
        int result = n * factorial(n - 1);
        System.out.println("end n= " + n);
        return result;
        // 0! = 1../ dieu kien co so
        // 1! = 1x0!
        // 2! = 2x1!
        // 3! = 3x2!
    }
    private static int Fibo(int n){
        count++;
        // 1 bài toán cơ sở
        System.out.println("start n= "+n);
        if(n <=2){
            System.out.println("end n = "+n);
            return 1;
        }

        // 2. công thưc quy nạp
        int Fn= Fibo(n-1) + Fibo(n-2);
        System.out.println("end n = "+n);
        return Fn;
        // arr[0] = f(0)
        // arr[n] = f(n)
    }
    static int count = 0;
    private static int fibo2(int n, int[]arr){
        count++;
        System.out.println("start n = "+n);
        if(n<=2){
            System.out.println("end n = "+n);
            return 1;
        }
        if(arr[n]==0){
            arr[n] = Fibo(n-1)+ Fibo(n-2);

        }
        System.out.println("end n = "+n);
        return arr[n];

    }


    public static void main(String[] args) {
//        printF(0);
//        doSomeThing();
//        System.out.println(factorial(0));
//        System.out.println(factorial(1));
//        System.out.println(factorial(2));
//        System.out.println(factorial(3));
        int[]arr = new int [1000];
        System.out.println(fibo2(5,arr));
        System.out.println("fibo2 count = "+count);
        count = 0;
        System.out.println(Fibo(5));
        System.out.println("fibo1 count = "+count);

    }

    private static void doSomeThing() {
        int mySum = sum(1, 2);
        System.out.println(mySum);
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
