import java.util.HashMap;
import java.util.Map;

public class Lc387 {
    public int firstUniqChar(String s) {
        int [] alphabet = new int['z' - 'a'+1];
        // bắt đầu từ 'a' -> index = 0 -> 'a' - 'a'
        // index c : 'c' - 'a' = 2
        // kết thúc tại 'z' -> index = 25
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            alphabet[cha-'a']++;  // cha - 'a' -. index tương ướng với character
        } // đếm được số lần xuất hiện của tất cả kí tự trong s
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if(alphabet[cha - 'a']==1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar1(String s) {
        int minIndex = Integer.MAX_VALUE;
        for (char c = 'a'; c <='z' ; c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)){
                minIndex = Math.min(index, minIndex);
            }
        }
        if(minIndex == Integer.MAX_VALUE){
            return -1;
        }
        return minIndex;
    }
    public int firstUniqChar2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int x = map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),x);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))== 1){
                return i;
            }
        }
        return -1;
    }
}
