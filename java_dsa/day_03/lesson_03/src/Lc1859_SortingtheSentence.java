import java.util.Arrays;

public class Lc1859_SortingtheSentence {
    public static String sortSentence(String s) {
        String[] arr = s.split(" ");                // tao mảng ta có 4 phần tử
        String[] newArr = new String[arr.length];         // tạo mảng mới có 4 phần tử

        for (int i=0; i<arr.length; i++) {
            int n = arr[i].length()-1;                      // khi i = 0 thì phần từ là is2 và có n = 2, i =1 n =8, i=2 n =4, i =3 n =1
            int index = arr[i].charAt(n) - '0';             // index = 2  ( trừ đi gtri 0 ) ,=4, = 1, = 3
            newArr[index-1] = arr[i].substring(0, n);       // newArr tại index = 1,3,0,2  sẽ bằng = ký tự từ  0 đến n-1(1,7,3,0)
        }
        return String.join(" ", newArr);            // tạo chuỗi nối mảng newArr vs dấu cách và sắp xếp nó
    }

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
