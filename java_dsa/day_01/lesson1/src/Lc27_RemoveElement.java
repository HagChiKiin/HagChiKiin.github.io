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
    public static int removeElement1(int[] nums, int val) { // Bài mr Tài
        int k = 0;
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            if(nums[i] != val ){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4,4,1};
        System.out.println(removeElement1(arr,2));
    }
}
