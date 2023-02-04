public class Lc1672 {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) { // duyệt từng hàng
            int sum = 0; // tính tổng tất cả các số trên hàng thứ i
            for (int j = 0; j < accounts[i].length; j++) {
                sum = sum + accounts[i][j];
            } // đã tính xong tổng của hàng thứ i
            max = Math.max(max, sum);
        }
        return max;
    }
}
