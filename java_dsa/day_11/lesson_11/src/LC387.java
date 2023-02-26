import java.util.HashMap;
import java.util.Map;

public class LC387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {  // neu c khong ton tai
                map.put(c, 1);  // them vao map ky tu c va lan xuat hien dau tien = 1
            } else {
                int x = map.get(c); // so lan xuat hien cua ky tu c
                map.put(c, x + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {   // neu lan dau tien gap ky tu c = 1 thi tra ve index
                return i;
            }
        }
        return -1;
    }
}
