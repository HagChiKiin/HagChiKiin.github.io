package classdemo;

public class Test {
    public static void main(String[] args) {
        // Tạo ra đối tượng từ class
        Person person = new Person();

        System.out.println(person.name);// null ( default value của String )
        // gán các giá trị cho thuộc tính đối tượng
        person.name = "Nguyễn Thành Kiên";
        person.email = "a@gmail.com";
        person.age = 29;
        person.address = "Đông Anh";

        // in ra thông tin của đối tượng
        System.out.println(person.name +" - " + person.email+" - "+person.age+" - "+person.address);
        person.eat();
        person.showInfo();
        person.play("bóng đá");

        System.out.println(person);

        // Khởi tạo đối tượng phone
        Phone phone = new Phone();
        phone.name = "Iphone 14 pro max";
        phone.brand = "Aplle";

        person.usePhone(phone);

        // pratice Calculator
        Calculator cal = new Calculator();
        cal.number1 = 10;
        cal.number2 = 0;
        cal.printInfo();
        System.out.println("Tổng 2 số: " +cal.addition());
        System.out.println("trừ 2 số: " +cal.subtract());
        System.out.println("Nhân 2 số: " +cal.multi());
        System.out.println("Chia 2 số: " +cal.division());
        System.out.println("code continue...");

        // Khởi tạo đói tượng person vs constructor
        Person person1 = new Person("trần văn a","a@gmail.com");
        System.out.println(person1);

        Person person2 = new Person("Ngô thị c","c@gmail.com",20,"Đông anh");
        System.out.println(person2);
    }

}
