import java.util.HashSet;
import java.util.Set;

public class MySet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        for (Integer i: set
             ) {
            System.out.println(i);
            
        }
    }
}
