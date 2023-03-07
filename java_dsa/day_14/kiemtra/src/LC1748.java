import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC1748 {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {   // gán c = num tại i
            c = nums[i];
            for (int j = i+1; j <nums.length ; j++) {   // duyệt từ j ke lien ben phai i
                if( c == nums[j]){                      // neu c cung bang num tai j
                    nums[i] =nums[j] = 0;     // ta gan num tai i bang num tai j va bang 0
                }
            }
            sum = sum + nums[i];
        }
        return sum;
    }

}
