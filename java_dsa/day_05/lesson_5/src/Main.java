public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 12, 19, 25, 31, 46, 50, 57, 72};
        System.out.println("indexof 9: " + binarySearch1(arr, 0, arr.length-1, 57));
        System.out.println("indexof 1: " + binarySearch(arr, 1));
        System.out.println("indexof 4: " + binarySearch(arr, 4));
    }

    private static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) { // leff==right -> mảng con chỉ chứa duy nhất 1 phần tử: a[l] = a[mid] = a[r]
                int mid = (left + right) / 2;
                if (arr[mid] == target) {
                    return mid;
                }
                if (arr[mid] < target) {
                    // range : mid+1 -> right
                    left = mid + 1;
                } else {
                    // range : left -> mid-1
                    right = mid - 1;
                }

        }
        return -1;
    }

    private static int binarySearch1(int[] arr, int left, int right, int target) {
        // điều kiện dừng
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearch1(arr, mid + 1, right, target);
        }
        return binarySearch1(arr, left, mid - 1, target);
    }
}
