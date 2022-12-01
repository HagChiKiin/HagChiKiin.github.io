public class Array_Demo {
    public static void main(String[] args) {
        // cách 1
        int[] array1 = new int[5];
        array1[0] = 1;
        array1[1] = 4;
        array1[2] = 3;
        array1[3] = 5;
        array1[4] = 6;
        System.out.println(" Số lượng phần tử = "+array1.length);
        System.out.println("Sử dụng for: ");
        //sử dụng for để duyệt mảng
        for(int index=0; index < array1.length; index++){
            System.out.println(index + array1[index]);
        }
        // sử dụng for each để duyệt mảng
        for (int value:array1
             ) {
            System.out.println(value);

        }

        // cách 2

        // cách 3
        int [] array3 = { 12, 14, 16, 8};
        int array4[] =  { 11, 15,15};
    }
}
