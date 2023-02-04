public class Lc344_ReverseString {
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            char t = s[i];
            s[i] = s[n-i-1];
            s[n-i-1]= t;
        }
        System.out.println(s);
    }
    public static void reverseString1(char[] s) {
        StringBuilder s1 = new StringBuilder();
        for (char a : s
             ) {s1.append(a);

        }
        s1.reverse();
        System.out.println(s1);
    }

    public static void main(String[] args) {
      char [] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}

