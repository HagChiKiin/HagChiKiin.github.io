public class Test {
    public static void main(String[] args) {
     int[] a= {0,1,20,13,4,5,6,7,8,9};
        System.out.println(sum(3,a));
    }
    // sum từ index = 0 -> bất kì
    private static int sum(int n ,int[]arr){
        // dieu kien dung
        if(n<0){
            // sum .->0;
            return 0;
        }
        return  arr[n] +sum(n-1,arr);
    }

}
