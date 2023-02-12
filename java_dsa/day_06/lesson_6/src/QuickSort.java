import javax.swing.*;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // pivot = 9
        // chia lay 2phan
        // left<9
        // right>9
        int [] a = {9,7,5,8,4,1,2};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void quickSort(int[]arr ,int low,int high){  // tìm dược 1 phần tử trong sorted
        if(low<high){
            int sorted = partition(arr,low,high);
            quickSort(arr,low,sorted-1);  // chia để tr
            quickSort(arr,sorted+1,high);
        }
    }
    private static int partition(int []arr, int low, int high){
        System.out.println("partition from "+low+" to high mm"+high);
        int pivot = arr[low];
        int left = low+1;
        int right = high;
        while (true){
            // tìm  phần tử phía trái mà lớn hơn pivot
            while (left <=right && arr[left]< pivot ){
                left++; // tim duoc arr[left] > pivot
            }
            while (left <=right && arr[right]>pivot  ){
                right --;
            }
            if(left>=right){
                break;
            }
            swap(arr,left,right);
            left++;
            right--;
        }
        System.out.println("pivot= "+pivot+" index= "+low+" right= "+right);
        swap(arr,low,right);
        return right;
    }

    private static void swap(int[]arr , int i ,int j) {
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
