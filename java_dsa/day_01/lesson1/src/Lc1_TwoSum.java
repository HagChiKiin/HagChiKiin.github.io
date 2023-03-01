import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];    // tạo mảng có 2 phần tử
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
           if(map.containsKey(target-nums[i])){    // nếu trong map có phần tử = target - num
               result[0] = map.get(target -nums[i]);   // lay ra gia tri target - num gan vao rel 0
               result[1] = i; // chi so i gan vao rel 1
               return result;
           }
            map.put(nums[i], i);  // them vao map

        }
        return result;
    }
    

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(twoSum(arr, 8)));
    }
}
