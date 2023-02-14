public class Lc1512 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;   // tạo biến đếm
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {   // j=i+1đảm bảo các phần tử không bị trùng lặp
                if(nums[i] == nums[j]){  // num tại i = num tại j thì ta tăng biến đếm
                    count++;
                }
            }
        }
        return count;
    }
}
