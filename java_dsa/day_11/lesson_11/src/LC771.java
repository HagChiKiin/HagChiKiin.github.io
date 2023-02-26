import java.util.HashSet;
import java.util.Set;

public class LC771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()   // duyet mang jewels
             ) { set.add(c);     // them vao set ky tu c
        }
        int count = 0;   // tao bien dem = 0
        for (char a : stones.toCharArray()   // duyet mang stones
             ) {
            if(set.contains(a)){        // neu trong set da co ky tu a thi tang bien count
                count++;
            }
        }
        return count;
    }
}
