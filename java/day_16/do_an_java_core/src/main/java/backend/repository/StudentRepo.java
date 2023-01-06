package backend.repository;

import backend.database.StudentDB;
import backend.database.UserDB;
import backend.model.Student;
import backend.model.User;
import backend.utils.UserUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepo {
    ArrayList<Student> students = StudentDB.students;
    User user = new User();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Student> findAll() {
        return StudentDB.students;
    }

}

