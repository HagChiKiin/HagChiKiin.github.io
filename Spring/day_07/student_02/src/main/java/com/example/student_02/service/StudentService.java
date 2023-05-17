package com.example.student_02.service;

import com.example.student_02.entity.Student;
import com.example.student_02.model.StudentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // cắm bean objecmapper vào bên trong thằng service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)  // cắm bean objecmapper vào bên trong thằng service
public class StudentService {

    ObjectMapper objectMapper;
    List<Student> students = new ArrayList<>();
    private static int AUTO_ID = 1;

    public List<StudentModel> getAlStudents() {   // convert sang model
        List<StudentModel> result = new ArrayList<>();
        for (Student a : students) {

            //         StudentModel studentModel = StudentModel.builder()
//                    .id(a.getId())
//                    .name(a.getName())
//                    .address(a.getAddress())
//                    .phone(a.getPhone())
//                    .dob(a.getDob())
//                    .gpa(a.getGpa())
//                    .build();

            StudentModel studentModel = objectMapper.convertValue(a, StudentModel.class); // hàm này tra về 1 object nên phải thêm StudentModel studentmodel = vào
            result.add(studentModel);
        }
        return result;
    }


    public void saveStudent(StudentModel studentModel) {   // convert sang entity
        Student student = objectMapper.convertValue(studentModel, Student.class);
        student.setId(AUTO_ID);
        students.add(student);
        AUTO_ID++;
    }

    public void delete(String id) {
//        students.stream().filter(s->s.getId() != id).collect(Collectors.toList());
        students.removeIf(a->a.getId()== Integer.parseInt(id));
    }
    public StudentModel findById(String id){  // convert sang entity
        Optional<Student> studentOptional = students
                .stream()
                .filter(s->s.getId() == Integer.parseInt(id))
                .findFirst();  // lay thang dau tien
        if(studentOptional.isEmpty()){
            return null;
        }
        Student student = studentOptional.get();
        StudentModel demo = objectMapper.convertValue(student, StudentModel.class);
        return demo;
    }
    public void updateStudent(StudentModel studentModel){ // convert sang entity
        students.forEach(s->{
            if(s.getId() != studentModel.getId()){
                return;
            }
            s.setName(studentModel.getName());
            s.setAddress(studentModel.getAddress());
            s.setDob(studentModel.getDob());
            s.setGpa(studentModel.getGpa());
            s.setPhone(studentModel.getPhone());
        });
    }

}
