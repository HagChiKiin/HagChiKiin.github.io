public class Lc485_MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max= 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;            // nếu giá trị tại i bằng 1 thì tăng biến đếm
                if(count > max){
                    max = count;   // nếu giá trị biến đếm lớn hơn max thì gắn max = biến đếm
                }
            }else {
                count= 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,1,0,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
