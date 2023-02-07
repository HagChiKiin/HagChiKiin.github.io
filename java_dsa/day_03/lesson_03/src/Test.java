import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student[] students = { new Student(" A Thành Kiên",16 ,8),
                new Student("A Thành Kiên",18 ,9),
                new Student("B Trần Anh",10 ,10),
                new Student("C Phan Công",10 ,7)};
        System.out.println("1.Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước.");
        Arrays.sort(students, (o1, o2) -> o1.fullName.compareTo(o2.fullName) + o2.age - o1.age);
        for (Student p :students
        ) {
            System.out.println(p);
        }
        System.out.println("-----------------");
        System.out.println( "2.Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần");
        Arrays.sort(students, (o1, o2) -> o1.age-o2.age+o2.GPA-o1.GPA);
        for (Student p :students
        ) {
            System.out.println(p);
        }
        System.out.println("3.Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi)");
        Arrays.sort(students, Comparator.comparing(o -> o.fullName.substring(o.fullName.lastIndexOf(" ") + 1)));
        System.out.println("-----------------");
        for (Student p :students
        ) {
            System.out.println(p);
        }
    }
}
