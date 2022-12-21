package database;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    public static ArrayList<Student> studentList;

    static {
        studentList = new ArrayList<>(List.of(
                new Student(1, "Kiên nguyễn", 20, "Đông anh", 5.5, "A1"),
                new Student(2, "Kiên to", 15, "Ba Vì", 9.2, "A2"),
                new Student(3, "Kiên bé", 21, "Long Biên", 7, "A3"),
                new Student(4, "Kiên đù", 20, "Đống Đa", 8, "A4")
        ));
        inIt();
    }


    private static void inIt() {

        studentList.add(new Student(5, "Trần tôn", 22, "Châu âu", 6.8, "A5"));
        studentList.add(new Student(6, "Nguyên tôn", 11, "Châu mỹ", 8, "A6"));
        studentList.add(new Student(7, "Lỗ tôn", 11, "Châu úc", 7.4, "A7"));
        studentList.add(new Student(8, "Đạo tôn", 12, "Châu phi", 9.9, "A1"));
    }
}
