public class Main {
    public static void main(String[] args) {
        int[][] arr2d = {
                {1,2,3,100,200},
                {4,5,6}
        };
        // arr2d.length : số hàng của ma trận
        for (int i = 0; i < arr2d.length; i++) {
            System.out.println("Độ dài của dòng thứ i= "+i+" là: "+arr2d[i].length);
            for (int j = 0; j < arr2d[i].length; j++) {  // in ra tất cả phần tu ở dòng thứ i
                System.out.print(arr2d[i][j]+" ");  // arr[row][col]
            }
            System.out.println("");
        }

        int[][] arr = new int [2][4];
        for (int i = 0; i < arr.length; i++) { // duyệt số dòng của mảng
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
