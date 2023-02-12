import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] a1={1,3,5,7,9};
//        int[] a2={2,4,6,8};
//        System.out.println(Arrays.toString(merge2Arrays(a1,a2)));
        int[] arr ={2,5,3,1,8,7,6,4};
        System.out.println("array: "+Arrays.toString(arr));
        int[] res = mergeSort(arr,0,arr.length-1);
        System.out.println("res = "+Arrays.toString(res));
    }
    private static int[] mergeSort( int[] a,int L, int R){
        System.out.println("chia đôi mảng từ: "+L+" đến: "+R);
        // mang co 1 phân tư là dc săp xep
        if(L==R){
            System.out.println("Mang co 1 phan tu index= "+L+" ,value= "+a[L]);
            return new int[] {a[L]};
        }
        int mid = L +(R-L)/2;
        int[]a1 = mergeSort(a,L,mid);
        int[] a2 = mergeSort(a,mid+1,R);
        int[] res = merge2Arrays(a1,a2);
        System.out.println("Done merge từ: "+L+" đến: "+R);

        return res;
    }
    private static int[] merge2Arrays(int[]a1,int[]a2){
        // a1, a2 sorted
        int n = a1.length;
        int m = a2.length;
        int[] res = new int [n+m];
        int index = 0 ;
        int i=0,j=0;
        while (i < a1.length && j < a2.length){
            if(a1[i] < a2[j]){
                res[index] =  a1[i]; // thêm a[i] vào res,, và a[i] đã ddc remove
                i++;   // tang i để xet phần tử kế tiếp
            }else {
                res[index] =  a2[j];
                j++;
            }
            index++;
        }
        while (i<a1.length){  // a1 còn phần tử, chắc chắn a2 đã hết phần tử
            // điền tất cả phần tử còn lại của 1 vào res
            res[index] = a1[i];
            index++;
            i++;
        }
        while (j<a2.length){
            res[index] = a2[j];
            index++;
            j++;
        }
        return res;
        // return res[] được sắp xếp, merge từ a1 và a2
    }
}
