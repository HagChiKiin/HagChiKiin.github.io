public class LC283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {           // duyệt từ đầu đến cuối mảng   T = n
            if(nums[i] !=0){        // nếu giá trị tại i khác 0 thì gia tri tại index = gia tri tại i
                nums[index] = nums[i];  // tăng index
                index++;
            }
        }
        for (int i = index; i < n ; i++) {   // duyệt từ index đến cuối mảng , các phần tử 0 sẽ ở cuối
            nums[i] = 0;
        }
    }  // vòng for 1. tìm kiếm tuần tự từ i = 0 đến i <n ... có wostcase n
}      // vòng for 2.  có wostcase cũng bằng n
        // độ phức tạp thuật toán O(n)+O(n) = O(2n) = O(n)