import java.util.Arrays;

public class Lc1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int a: nums
             ) {
            if(new StringBuilder().append(a).length() % 2 == 0)count++;

            
        }
        return count;
    }
   }
