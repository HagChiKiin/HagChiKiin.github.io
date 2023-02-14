public class Lc75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        while (n>=2){  // chạy vòng lặp khi n lớn hơn 1( mảng nhiều hơn 1 phần tử)
            for (int i = 0; i < nums.length-1; i++) {  // do so sánh i vs i+1 nên vòng lặp i phải  < hơn n-1 hoặc <= n-2
                if(nums[i] > nums[i+1]){  // nếu phần tử tại i lớn hơn i+1 thì tến hành đổi chỗ
                    int t = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = t;
                }
            }
            n--;
        }
    }
}
