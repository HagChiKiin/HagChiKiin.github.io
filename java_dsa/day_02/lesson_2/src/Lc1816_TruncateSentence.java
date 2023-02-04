import java.util.Arrays;

public class Lc1816_TruncateSentence {
    public static String truncateSentence(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {  // nếu ký tự tại index i == 1 từ  thì biến count tăng 1
                count++;
            }
            if(count == k){
                return s.substring(0,i);// trả chuỗi từ vị trí index = 0 đến vị trí có index = i-1
            }
        }
        return s;
    }
    public static String truncateSentence1(String s, int k) {
        String[] s1 = s.split(" "); // tạo mảng s1 sau khi bỏ dấu cách
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s2.append(s1[i]);
            s2.append(" ");                 // nối chuỗi các giá trị s1 tại i và thêm dấu cách
        }
        return s2.toString().trim();  // trả về mảng String và bỏ khoảng trắng đầu và cuối

    }


    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
        System.out.println(s.substring(0,4));
    }
}
