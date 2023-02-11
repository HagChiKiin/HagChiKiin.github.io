public class LC374 {
    public static int guessNumber(int n) {  // 1<= pick<=n
        int left = 1;
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0; // vì chạy left luôn luôn <= right nên return gì cũng đc
    }

    public static int guess(int num) {
        int pick = 8;
        if (num < pick) {
            return 1;
        } else if (num == pick) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("số chọn là: ");
        System.out.println(guessNumber(100));
    }

}
