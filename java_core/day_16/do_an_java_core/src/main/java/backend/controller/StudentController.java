package backend.controller;

import backend.model.Student;
import backend.request.CreateStudent;
import backend.request.UpdateStudent;
import backend.service.StudentService;

import java.util.ArrayList;

public class StudentController {
    private final StudentService studentService = new StudentService();
    public ArrayList<Student> findAll() {
        return studentService.findAll();

    }


// UI thao tác đến controller
    public ArrayList<Student> getStudentById(String name, int id) {
        return studentService.getStudentById(name,id);
    }

    public Student addStudent(CreateStudent request) {
        return studentService.addStudent(request);
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
    }

    public Student update(int id, UpdateStudent request) {
        return studentService.update(id,request);
    }
}
