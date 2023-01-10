package backend.service;

import backend.model.Student;
import backend.repository.StudentRepo;
import backend.request.CreateStudent;
import backend.request.UpdateStudent;

import java.util.ArrayList;

public class StudentService {
    private final StudentRepo studentRepo = new StudentRepo();
    public ArrayList<Student> findAll() {
        return studentRepo.findAll();
    }

    public ArrayList<Student> getStudentById(String name, int id) {
        return studentRepo.getStudentById(name,id);
    }

    public Student addStudent(CreateStudent request) {
        Student student = new Student();
        student.setId(request.getId());
        student.setFullName(request.getFullName());
        student.setBirthday(request.getBirthday());
        student.setGender(request.getGender());
        student.setAddress(request.getAddress());
        studentRepo.add(student);
        return student;
    }

    public void deleteStudent(int id) {
        // Không có Id -> Thì báo lỗi
        Student student  = studentRepo.findById(id);

        // Có Id -> Xóa
        studentRepo.delete(student);
    }

    public Student update(int id, UpdateStudent request) {
        return studentRepo.update(id,request);
    }
}
