import java.util.HashMap;
import java.util.Map;

public class Lc136_SingleNumber {
    public static int singleNumber(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums
             ) {map.put(i, map.getOrDefault(i,0)+1);   // thêm phần tử có key = i  và có value = 0
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue()==1){        // nếu giá trị tại value = 1 thì lấy ra giá trị key
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,4,5,2,2,4};
        System.out.println(singleNumber(arr));
    }
}
