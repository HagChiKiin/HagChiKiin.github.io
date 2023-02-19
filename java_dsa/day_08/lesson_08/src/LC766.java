public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {  // chạy n-1 lần
            for (int j = 1; j < matrix[0].length; j++) { // chạy m-1 lần
                if (matrix[i][j] != matrix[i-1][j-1]) {  // ta xét phần tử thứ i-1 và j-1 ( phần tử đằng trước i và j nên phải duyệt i vs j từ 1
                    return false;
                }
            }
        }
        return true;  // nếu phần tử thứ i,j bằng phần tử i-1 và j-1 thì nó nằm trên cùng đường chéo
    }
}
//       vòng for 1 thực hiện n-1 lần vs n là số phần tử của i(hàng)
//       vòng for 2 thực hiện m-1 lần vs m là số phần tử của j(cột)
// tổng thời gian thực hiện là  0((n-1)*(m-1)) = O(nm)
