import java.util.Arrays;

public class LC_912_Quicksort {
    public static void main(String[] args) {
        // pivot = 9
        int [] a = {9,7,5,8,4,1,2};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void quickSort(int[]arr ,int low,int high){  // tìm dược 1 phần tử trong sorted
        if(low<high){
           int pivotIndex = partition(arr,low,high);
           quickSort(arr,low,pivotIndex-1);
           quickSort(arr,pivotIndex+1,high);
        }
    }
    private static int partition(int []arr, int low, int high){
        int pivot = arr[high];
        int left = low;
        int right = high-1;
        while (left<=right){
            // tìm  phần tử phía trái mà lớn hơn pivot
            while (left <=right && arr[left]< pivot ){
                left++; // tim duoc arr[left] > pivot
            }
            while (right>=0 && arr[right]>pivot){
                right --; // tim duoc arr[right] < pivot
            }
            if(left>=right){
                break;
            }
            swap(arr,left,right);
            left++;
            right--;
        }
        swap(arr,left,high);
        return left;
    }

  private static void swap(int[]arr , int i ,int j) {
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
