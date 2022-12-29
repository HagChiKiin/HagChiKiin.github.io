package functional_interface_build_in;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo<T> {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50, 25, 31));

//        numbers.removeIf(number -> number > 30);
//        System.out.println(numbers);
        Predicate<Integer> predicate = item -> item > 30;
        Predicate<Integer> predicate1 = item -> item % 2 == 0;
        Predicate<Integer> predicate2 = item -> item % 2 != 0;
        List<Integer> rs = filterList(numbers, predicate);
        System.out.println(rs);
        System.out.println("------------");
        List<Integer> rs1 = filterList(numbers, predicate1);
        System.out.println(rs1);
        System.out.println("------------");
        List<Integer> rs2 = filterList(numbers, predicate2);
        System.out.println(rs2);

        PredicateDemo<Integer> predicateDemo = new PredicateDemo();
        List<Integer> rs4 = predicateDemo.filterList(numbers,predicate);
        System.out.println(rs4);



    }

    public List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> rs = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                rs.add(item);
            }
        }
        return rs;
    }
}
