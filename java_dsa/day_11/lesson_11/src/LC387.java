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
            if (map.get(s.charAt(i)) == 1) {   // neu lan dau tien gap ky tu  thi tra ve index
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int x = map.getOrDefault(s.charAt(i),0)+1;
// Trả về giá trị tương ứng với key đã cho nếu key này đã có trong Map, hoặc trả về giá trị mặc định (0)nếu key này chưa có trong Map
// Sau đó, chúng ta tăng giá trị đã lấy được lên 1 và đưa nó vào Map với key là ký tự hiện tại.
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
