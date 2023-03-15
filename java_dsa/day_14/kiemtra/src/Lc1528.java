import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc1528 {
    public static String restoreString(String s, int[] indices) {
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(indices[i], s.charAt(i));
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result = result + map.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
}
