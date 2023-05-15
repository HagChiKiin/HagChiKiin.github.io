package com.example.thymeleaf01.controller;

import com.example.thymeleaf01.model.Student;
import com.example.thymeleaf01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public class StudentController {

    //    @Autowired
    StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    //    @RequestMapping
    @GetMapping
    public String getStudents(Model model) {
        List<Student> students = studentService.getAlStudents();
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model) {
        Student student = new Student();
        model.addAttribute("sinhVienToiMuonTaoMoi", student);
        return "create-student";
    }

    @PostMapping
    public String createNewStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}

