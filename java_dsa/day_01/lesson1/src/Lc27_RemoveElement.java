import java.util.HashMap;
import java.util.Map;

public class Lc27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n ;) {
            if(nums[i] == val){
                for (int j = i; j <= n-2 ; j++) {
                    nums[j] = nums[j+1];
                }
                n--;
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4};
        System.out.println(removeElement(arr,2));
    }
}
