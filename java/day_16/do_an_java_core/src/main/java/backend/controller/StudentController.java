package backend.controller;

import backend.model.Student;
import backend.service.StudentService;

import java.util.ArrayList;

public class StudentController {
    private final StudentService studentService = new StudentService();
    public ArrayList<Student> findAll() {
        return studentService.findAll();

    }
}
