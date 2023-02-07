import java.util.Arrays;
import java.util.Comparator;

public class Lc1859_SortingtheSentence {

    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, (o1, o2) -> o1.charAt(o1.length()-1)-o2.charAt(o2.length()-1));//sắp xếp theo vị trí cuối cùng các phần tử của mảng
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0,arr[i].length()-1);  // lấy ra phần tử từ index=0 > index = leng-2
        }
        return String.join(" ",arr);
    }
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
