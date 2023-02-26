import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyMap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 3, 4};
        // key : gia tri cua phan tu trong mang
        // value: so luong xuat hien cua cac phan tu trong mang

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr
        ) {
            if (map.containsKey(i) == false) {
                // i chua xuat hien trong map
                map.put(i, 1);
            } else {
                // i da xuat hien truoc do
                int count = map.get(i); // so lan xuat hien
                count++;
                map.put(i, count);
            }
        }
        for (Map.Entry entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");

        }
        String[] s = {"kien", "hoang", "kien"};
        Map<String, Integer> map1 = new HashMap<>();
        for (String i : s
        ) {
            if (map1.containsKey(i) == false) {
                // i chua xuat hien trong map
                map1.put(i, 1);
            } else {
                // i da xuat hien truoc do
                int count = map1.get(i); // so lan xuat hien
                count++;
                map1.put(i, count);
            }
        }
        for (Map.Entry entry : map1.entrySet()
        ) {
            System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");


//            Set<Integer> set = new HashSet<>();
//            set.add(1);
//            set.add(2);
//            System.out.println(set.contains(3)); // return false

        }
    }
}
