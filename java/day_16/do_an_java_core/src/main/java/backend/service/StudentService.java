package backend.service;

import backend.model.Student;
import backend.repository.StudentRepo;

import java.util.ArrayList;

public class StudentService {
    private final StudentRepo studentRepo = new StudentRepo();
    public ArrayList<Student> findAll() {
        return studentRepo.findAll();
    }

    public ArrayList<Student> getStudentById(String name, int id) {
        return studentRepo.getStudentById(name,id);
    }
}
