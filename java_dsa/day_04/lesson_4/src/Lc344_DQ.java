public class Lc344_DQ {
    public static void swap(char[]s , int i, int j){  // i: con trỏ chạy từ trái qua. j con trỏ chạy từ phải qua
        System.out.println("start i = "+i + ", j= "+j);
        if(i>= j){
            System.out.println("end i = "+i + ", j= "+j);
            return;
        }
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        System.out.println(s);
        swap(s,i+1,j-1);
        System.out.println("end i = "+i + ", j= "+j);

    }
    public static void reverseString(char[] s) {
        swap(s,0,s.length-1);
    }

    public static void main(String[] args) {
        char[] s ={'h','e','l','l','o'};
        swap(s,0,s.length-1);
    }
}
