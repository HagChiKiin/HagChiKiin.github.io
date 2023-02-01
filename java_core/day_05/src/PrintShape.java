public class PrintShape {
    public static void main(String[] args) {
        printRectange(5, 3);

        printEmptyRectange(10, 5);
        printX(31);
    }

    //In hình chữ nhật đặc
    public static void printRectange(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    //In hình chữ nhật  rỗng
    public static void printEmptyRectange(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();

        }
    }

    //In dấu X
    public static void printX(int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (i == j || i + j == side - 1) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

