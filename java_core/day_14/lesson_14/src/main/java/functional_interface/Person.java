package functional_interface;


public class Person implements Greeting{
    @Override
    public void sayHello(String name) {
        System.out.println("Xin chào "+ name);
    }
    public static void main(String[] args) {
        // Cách 1 : Sử dụng class cụ thể
        Greeting greeting = new Person();
        greeting.sayHello("Kien");
        // Cách 2 : sử dụng anonymous class
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " +name);
            }
        };
        greeting1.sayHello("Kiên to");
        // Cách 3: sử dụng lamda expresstion
        Greeting greeting2 = name -> {
            System.out.println("Konichiwa "+ name);
        };
        greeting2.sayHello("Eimi fukada");
    }

}
