public class LC278  {
    public static int firstBadVersion(int n) {    // 1<= bad <= n <= 2^31-1
        int left = 1;
        int right = n;
        while (left < right) {                 // Lặp cho đến khi phạm vi tìm kiem chi con 1
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {  // phương thức isbadversion tại mid
                right = mid;       // nếu trả về true thi sẽ tiêp tuc kiểm tra ở mảng bên trái vs left vẫn 1 và right = mid
            } else {
                left = mid + 1;     // nếu trả về false thì sẽ kiểm tra mảng ở bên phải vs left = mid +1 và right vẫn = n
            }
        }
        return left;  // nêu left = right thì trả về left =1
    }
    public static boolean  isBadVersion(int version){
        return version >=4;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(6));
    }
}