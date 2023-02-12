import java.util.Arrays;

public class main1 {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 8};
        int[] a2 = {2, 4, 8, 9};
        System.out.println(Arrays.toString(merge2Arrays(a1, a2)));
    }

    private static int[] merge2Arrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int i = 0;
        int j = 0;
        int ind = 0;
        int [] a3 = new int[n+m];
        while (i < n && j <m){
            if(a1[i] < a2[j]){
                a3[ind] = a1[i];
                i++;
            }else {
                a3[ind] = a2[j];
                j++;
            }
            ind++;
        }
        while (i<n){
            a3[ind++] = a1[i++];
        }
        while (j<m){
            a3[ind++] = a2[j++];
        }
        return a3;
    }
}
