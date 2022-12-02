public class Practice {
    public static void main(String[] args) {
        Array1();
    }
    public static int Array1(){
        int [] array = { 4, 5, 8, 9 ,7};
        for (int i = 0; i <array.length ; i++) {
            if(array[i] % 2 ==0){
                array[i]=0;
            }else {
                array[i] =1;
            }
            System.out.print(array[i]+ " ");
        }
        return array[];
    }


}
