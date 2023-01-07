package backend.repository;

import backend.database.StudentDB;
import backend.model.Student;
import backend.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepo {
    ArrayList<Student> students = StudentDB.students;
    User user = new User();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Student> findAll() {
        return StudentDB.students;
    }

    public ArrayList<Student> getStudentById(String name, int id) {
        ArrayList<Student> students1 = StudentDB.students;
        ArrayList<Student> rs = new ArrayList<>();
        boolean ixist = false;
        for (Student s : students1
        ) {
            if (s.getId() == id && s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(s);
                ixist = true;
            }
        }
        if (!ixist) {
            System.out.println("Nhập chưa đúng, vui lòng kiểm tra lại thông tin cá nhân");
        }
        return rs;
    }
}

