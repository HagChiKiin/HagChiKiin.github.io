package functional_interface_build_in;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        // Khai báo 1 list
        List<String> names = List.of("Hiên", "An", "Hằng", "Duy");

        // Cách 1 : Triền khai functional interface Consumer bằng anonymous class
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        });

        // Cách 2 : Tạo đối tượng Consumer
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        };
        // Truyền đối tượng vừa tạo vào trong forEach
        names.forEach(consumer);

        // Cách 3 : Sử dụng Lambda expresstion để triển khai Consumer
        names.forEach(a -> System.out.println(a.toLowerCase()));
//        (argument-list) -> {body}
//        Argument-list: danh sách tham số (có thể không có, có một hoặc nhiều tham số)
//        Arrow-operator: toán tử mũi tiên được sử dụng để liên kết danh sách tham số và body của biểu thức.
//        Body: nội dung thực thi, là 1 khối lệnh hoặc 1 biểu thức.
        Consumer<String> consumer1 = name -> System.out.println(name.toLowerCase());
        print(names,consumer);
        print(names,consumer1);

        // Cách 4 : Sử dụng method reference
        names.forEach(System.out::println);

    }
    public static void print(List<String> list, Consumer<String> consumer){
        for (String ele: list
             ) {
            consumer.accept(ele);

        }
    }
}
