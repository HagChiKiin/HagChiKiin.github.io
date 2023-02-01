package InheritanceDemo;

public class Test {
    public static void main(String[] args) {
        // Khởi tạo đối tượng dog từ lớp Dog
        Dog dog = new Dog("Husky","white",4);

        // truy cập vào field của class Animal

        dog.display(); // Gọi phương thức của lớp Dog
        dog.eat(); // Gọi phương thức của lớp Animal



        Dog dog1 = new Dog();
        dog1.setName("Corgi");
        dog1.setColor("black");
        dog1.setLegs(4);
        // Gọi 1 số phương thức ứng với dog1 instance
        dog1.eat();
        dog1.display();

    }
}
