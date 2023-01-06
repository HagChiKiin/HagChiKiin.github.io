package backend.database;

import backend.model.Student;
import backend.utils.StudentUtils;

import java.util.ArrayList;

public class StudentDB {
    public static ArrayList<Student> students = StudentUtils.getDataFromJsonFile("student.json");

}
