public class Lc912 {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0, nums.length-1);
    }
    public int[] mergeSort(int[] a,int L, int R){
        // Điều kiện dừng
        if(L>R){
            return new int[0];
        }
        if(L==R){
            int[] singleElement = {a[L]};
            return singleElement;
        }
        int mid = L +(R-L)/2;
        int[] a1 = mergeSort(a,L,mid);
        int[] a2 = mergeSort(a,mid+1,R);

        int n = a1.length + a2.length;
        int[] result = new int[n];
        int i = 0,i1 = 0, i2=0;
        while (i<n){
            if(i1<a1.length && i2<a2.length){
                if(a1[i1] <= a2[i2]){
                    result[i] = a1[i1];
                    i++;i1++;
                }else {
                    result[i] = a2[i2];
                }
            }else {
                if(i1<a1.length){
                    result[i] = a1[i1];
                    i++;i1++;
                }else {
                    result[i] = a2[i2];
                    i++;i2++;
                }
            }

        }
        return result;

    }
}
