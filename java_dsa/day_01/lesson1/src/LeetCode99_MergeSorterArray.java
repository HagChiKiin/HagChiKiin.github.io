public class LeetCode99_MergeSorterArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // m : độ dài của dãy nums1
        // m-1 phần tử cuối cùng của nums1
        // tìm vị trí cần insert
        int lengthOfNums1 = m;
        int lengthOfNums2 = n;
        for (int i = 0; i < nums2.length; i++) {   // lấy ra phần tử trong mảng 2
            // tìm vị trí cần insert : là vịt rí của phần tử đầu tiên lớn hơn number tại i
            for (int j = 0; j < lengthOfNums1; j++) {
                if (nums2[i] < nums1[j]) {
                    insert(j, nums2[i], lengthOfNums1, nums1);
                    lengthOfNums1++;
                    lengthOfNums2--;
                    break;
                }
            }
        }
        if(lengthOfNums2>0){
            int index = m+n-lengthOfNums2+1;
            while (index < m+n){
                nums1[index] = nums2[m-lengthOfNums2];
                index++;
                lengthOfNums2++;
            }
        }

    }

    private static void insert(int index, int number, int lengthOfNums1, int[] arr) {
        for (int i = lengthOfNums1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = number;
        for (int k :arr
             ) {
            System.out.println(k+" ");
        }
        System.out.println("--------");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 6, nums2, 3);
        System.out.println(nums1);
    }
}
