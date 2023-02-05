public class Lc1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder r1 =  new StringBuilder();
        StringBuilder r2 =  new StringBuilder();
        for (String s : word1
             ) {
            r1.append(s); // nối các String s trong mảng word1
        }
        for (String s: word2
             ) {
            r2.append(s);
        }
        return r1.toString().equals(r2.toString());  // chuyển từ string builder qua string  và so sánh
    }
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        String s1 = String.join("",word1);
        String s2 = String.join("",word2);
        return s1.equals(s2);
    }
}
