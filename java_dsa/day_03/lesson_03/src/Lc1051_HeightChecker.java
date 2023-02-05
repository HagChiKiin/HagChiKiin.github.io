import java.util.Arrays;

public class Lc1051_HeightChecker {
    public int heightChecker(int[] heights) {
        int count =0;
        int [] arr = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            arr[i]=heights[i];
        }
        Arrays.sort(arr);

        for(int i =0; i<heights.length;i++){
            if(heights[i]!=arr[i]){
                count++;
            }
        }
        return count;
    }
}
