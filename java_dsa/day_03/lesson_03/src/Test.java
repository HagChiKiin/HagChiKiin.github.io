import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student[] students = { new Student("A Thành Kiên",16 ,8),
                new Student("A Thành Kiên",18 ,9),
                new Student("B Trần Anh",20 ,7),
                new Student("C Phan Công",20 ,10)};
        System.out.println("1.Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước.");
        Arrays.sort(students, (o1, o2) -> {
            if(o1.fullName.equals(o2.fullName)){
                return o2.age-o1.age;
            }
            return o1.fullName.compareTo(o2.fullName);
        });
        for (Student p :students
        ) {
            System.out.println(p);
        }
        System.out.println("-----------------");
        System.out.println( "2.Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần");
        Arrays.sort(students, (o1, o2) -> {
            if(o1.age==o2.age){
                return o2.GPA-o1.GPA;
            }
            return o1.age-o2.age;
        });
        for (Student p :students
        ) {
            System.out.println(p);
        }
        System.out.println("-----------------");
        System.out.println("3.Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi)");
        Arrays.sort(students, Comparator.comparing(o ->o.fullName.substring(o.fullName.lastIndexOf(" ")+1)));
        for (Student p :students
        ) {
            System.out.println(p);
        }
    }
}
