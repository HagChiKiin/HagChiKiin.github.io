public class bai1 {
    public static void main(String[] args) {
        printSquare(4);
        System.out.println();
        printTriangle(4);
    }

    public static void printSquare(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void printTriangle (int b) {
        for (int i=0;i< b;i++){
            for (int j=0;j< b;j++) {
                if (i<j) {
                    System.out.print(" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
