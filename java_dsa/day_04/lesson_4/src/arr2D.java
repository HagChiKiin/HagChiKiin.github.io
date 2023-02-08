public class arr2D {
    public static void print2DArray(int[][] arr, int i, int j) {
        // điều kiện dừng
        System.out.println("start i = "+i + ", j= "+j);
        if (i<0 || j<0 || i>= arr.length) {
            System.out.println("end i = "+i + ", j= "+j);
            return;
        }
        // công thức quy nạp, in phần từ ij và print i+1 và j+1
        if (j == arr[0].length) {
            print2DArray(arr, i + 1, 0);
            System.out.println("end i = "+i + ", j= "+j);
            return;
        }
        // công thức quy nạp, in phần từ ij và print j+1
        System.out.println(arr[i][j] + " ");
        print2DArray(arr, i, j + 1);
        System.out.println("end i = "+i + ", j= "+j);
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        print2DArray(array, 0, 0);

    }
}
