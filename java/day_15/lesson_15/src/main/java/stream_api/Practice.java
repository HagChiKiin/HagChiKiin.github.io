package stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);
//        Duyệt numbers
        numbers.forEach(System.out::print);
        System.out.println();
//        Tìm các giá trị chẵn trong list
        numbers.stream().filter(i -> i % 2 == 0).forEach(System.out::print);
        System.out.println();
//        List<Integer> rs = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
//        Tìm các giá trị > 5 trong list
        numbers.stream().filter(i -> i > 5).forEach(System.out::print);
        System.out.println();
//        Tìm giá trị max trong list
        // c1
        List<Integer> listsortAsc = numbers.stream().sorted().collect(Collectors.toList());
        Integer max = listsortAsc.get(listsortAsc.size() - 1);
        System.out.println(max);
        // c2
        Optional<Integer> optionalMax = numbers.stream().max(Comparator.comparingInt(a -> a));
        optionalMax.ifPresent(System.out::println);

//        Tìm giá trị min trong list

//        Tính tổng các phần tử của mảng
        Integer total = numbers.stream().mapToInt(n -> n ).sum();
        System.out.println("Total: " + total);

        int total1 =numbers.stream().reduce(0,(a,b)-> a+ b);
        System.out.println("Total1: "+ total1);
//        Lấy danh sách các phần tử không trùng nhau
        numbers.stream().distinct().forEach(System.out::print);
        System.out.println();
//        Lấy 5 phần tử đầu tiên trong mảng
        numbers.stream().limit(5).forEach(System.out::print);
        System.out.println();
//        Lấy phần tử từ thứ 3 -> thứ 5
        numbers.stream().skip(2).limit(3).forEach(System.out::print);
        System.out.println();
//        Lấy phần tử đầu tiên > 5
        List<Integer> list = numbers.stream().filter(i->i>15).limit(1).toList();
        if(list.size()>0){
            System.out.println(list.get(0));
        }
        System.out.println();
        numbers.stream().filter(i->i>5).findFirst().ifPresent(System.out::println);
//        Kiểm tra xem list có phải là list chẵn hay không
        System.out.println(numbers.stream().allMatch(n -> n%2 ==0));
//        Kiểm tra xem list có phần tử > 10 hay không
        System.out.println(numbers.stream().anyMatch(n -> n>10));
//        Có bao nhiêu phần tử > 5
        System.out.println(numbers.stream().filter(n->n>5).count());
//        Nhân đôi các phần tủ trong list và trả về list mới
        List<Integer> listx2 =numbers.stream().map(n-> n*2).toList();
        System.out.println(listx2);
//        Kiểm tra xem list không chứa giá trị nào = 8 hay không
        System.out.println(numbers.stream().noneMatch(n->n==8));
    }
}

