package com.example.demoweb01.controller;

import com.example.demoweb01.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String getStudent(Model model) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "Nguyễn Văn " + i, "10A" + i, i));
        }

        // camel case
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }

}
