public class LC35 {
    public int searchInsert(int[] nums, int target) { //  k tham khảo
        int left = 0, right = nums.length - 1;
        while (left <= right) { // leff==right -> mảng con chỉ chứa duy nhất 1 phần tử: a[l] = a[mid] = a[r]
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                // range : mid+1 -> right
                left = mid + 1;
            } else {
                // range : left -> mid-1
                right = mid - 1;
            }
        }
        return right+1;
    }
}
