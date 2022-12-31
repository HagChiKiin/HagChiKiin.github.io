package optional_demo;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalS = Optional.empty();
        Optional<String> optionalS1 = Optional.of("Hello");
        Optional<String> optionalS2 = Optional.ofNullable(null);
        System.out.println(optionalS1.get()); // Lấy giá trị
        // Kiểm tra trước khi lấy giá trị
        // Nếu bên trong optional có giá trik => Thực hiện hành động
        if (optionalS.isPresent()) {
            System.out.println(optionalS.get());
        } else {
            System.out.println("No value");
        }
        if (optionalS1.isPresent()) {
            System.out.println(optionalS1.get());
        } else {
            System.out.println("No value");
        }
        // Nếu bên trong optional rỗng => thực hiện hành động
        if (optionalS2.isEmpty()) {
            System.out.println("No value");
        } else {
            System.out.println(optionalS2.get());
        }
        // Nếu có giá trị bên trong optional => Làm hành động gì đó với optional
        optionalS.ifPresent(System.out::println);
        // Nếu không có giá trị bên trong optional => Trả về giá trị mặc định
        String massage = optionalS.orElse("world");
        System.out.println(massage);
        // Nếu có giá trị thì.... nếu không thì in ra lỗi
        try{
            String massage1 = optionalS.orElseThrow(() -> {
                throw new RuntimeException("Có lỗi xảy ra ");});
        }catch (RuntimeException e){
            System.out.println(e.getMessage());

        }


    }
}

