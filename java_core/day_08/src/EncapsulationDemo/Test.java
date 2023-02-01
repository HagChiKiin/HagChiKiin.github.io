package EncapsulationDemo;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(-1);
        person.setName("Kiên");
        person.setAge(29);
        person.setEmail("a@gmail.com");
        System.out.println(person); // in ra toString bên class Person

        // Khởi tạo person với constructor có tham số
        Person person1 = new Person(1, "Nguyễn Thu Hằng", 30, "hang@gmail.com");

        // In ra đối tượng
        System.out.println(person1);

        // Đọc ra 1 số thông tin của person
        System.out.println(person1.getName());
        System.out.println(person1.getEmail());

        // Đặt lại 1 số thông tin
        person1.setName("Nguyễn Bích Ngọc");
        person1.setEmail("bichngoc@gmail.com");

        // In lại thông tin của đối tượng sau khi thay đổi
        System.out.println(person1);

    }
}
