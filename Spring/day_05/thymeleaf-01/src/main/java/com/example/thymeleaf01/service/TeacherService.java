package com.example.thymeleaf01.service;

import com.example.thymeleaf01.model.Teacher;
import com.example.thymeleaf01.request.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final List<Teacher> teachers = new ArrayList<>();

    public void createDataTeacher() {
        for (int i = 0; i < 10; i++) {
            Teacher teacher = Teacher.builder()
                    .id(i)
                    .name("Nguyễn Thij " + i)
                    .address("Hà Nội " + i)
                    .dob(LocalDate.now())
                    .specialization("môn" + i)
                    .build();
            teachers.add(teacher);
        }
    }

    public List<Teacher> getAllTeacher() {
        createDataTeacher();
        return teachers;
    }


    public void saveTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Teacher findById(int id) {
        for (Teacher a : teachers) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public void updateTeacher(Teacher teacher, Update upd, int id) {
        for (Teacher a : teachers) {
            if (a.getId() == id) {
                a.setName(upd.getName());
                a.setPhone(upd.getPhone());
                a.setAddress(upd.getAddress());
                a.setDob(upd.getDob());
                a.setSpecialization(upd.getSpecialization());
                saveTeacher(teacher);
            }
        }
    }

    public void deleteTeacher(int id) {
        teachers.removeIf(a -> a.getId() == id);
       
    }


}