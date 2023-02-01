package upcasting_demo;

public class Test {
    public static void main(String[] args) {
        Person p = new Student("Kiên");
        // Nếu method được overide bởi lớp con > gọi method overide ở lớp con
        // Nếu method không overide bởi lớp con > gọi method của lớp cha
        p.eat();
        p.sleep();
        p.work();
       ((Student)p).display();
        System.out.println();

        // Dowcasting
        Student student = (Student) p;
        student.display();
        student.eat();
        student.sleep();
        student.work();
    }
}
