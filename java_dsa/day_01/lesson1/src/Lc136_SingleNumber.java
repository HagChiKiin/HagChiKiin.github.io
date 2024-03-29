import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc136_SingleNumber {
    public static int singleNumber(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();

        for (int i : nums) {
            int x = map.getOrDefault(i,0)+1;
            map.put(i,x);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) { // Map vừa tạo
            if(entry.getValue()==1){        // nếu giá trị tại value = 1 thì lấy ra giá trị key
                return entry.getKey();
            }
        }
        return 0;
    }
    public static int singleNumber1(int[] nums) { // bài Trọng
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2) {
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        int[] arr = {3,3,2,4,2,};
        System.out.println(singleNumber(arr));
    }

}


