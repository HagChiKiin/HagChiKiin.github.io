public class Lc69 {
    public int mySqrt(int x) {
        if(x<2)return x;
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = left +(right-left)/2;
            if(x/mid == mid){
                return mid;  // mid^2 = x
            }
            if(x/mid >mid){
                left = mid +1; // mid chưa đủ lớn -> cần check ở range nhỏ hơn
            }else {
                right = mid -1 ; // mid quá ớn -> cần check range nhỏ hơn
            }
        }
        return right;
    }
}
