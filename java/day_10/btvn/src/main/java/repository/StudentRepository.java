package repository;

import database.StudentDatabase;
import model.Student;

import java.util.ArrayList;

public class StudentRepository {
    public ArrayList<Student> allStudent(){
        return StudentDatabase.studentList;
    }
}
