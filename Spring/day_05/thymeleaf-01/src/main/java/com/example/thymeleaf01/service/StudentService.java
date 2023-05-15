package com.example.thymeleaf01.service;

import com.example.thymeleaf01.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private static final

    public List<Student> getStudents() {
        return students;
    }

//    public void createData() {
//        for (int i = 0; i < 10; i++) {
//            Student student = Student.builder()
//                    .id(i)
//                    .name("Nguyễn Văn " + i)
//                    .address("Hà Nội " + i)
//                    .dob(LocalDate.now())
//                    .gpa(i)
//                    .build();
//            students.add(student);
//        }
//    }

//    static {
//        for (int i = 0; i < 10; i++) {
//            Student student = Student.builder()
//                    .id(i)
//                    .name("Nguyễn Văn " + i)
//                    .address("Hà Nội " + i)
//                    .dob(LocalDate.now())
//                    .gpa(i)
//                    .build();
//            students.add(student);
//        }
//    }

    public List<Student> getAlStudents() {
//        createData();
        return students;
    }


    public void saveStudent(Student student) {
        student.setId(students.size());
        students.add(student);
    }

    public void delete(String id) {
//        students.stream().filter(s->s.getId() != id).collect(Collectors.toList());
        students.removeIf(a->a.getId()== Integer.parseInt(id));
    }
    public Student findById(String id){

    }
}
