package com.example.student_02.controller;

import com.example.student_02.entity.Student;
import com.example.student_02.model.StudentModel;
import com.example.student_02.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    @GetMapping
    public String getStudents(Model model) {
        List<StudentModel> studentModels = studentService.getAlStudents();
        model.addAttribute("danhSachSinhVien", studentModels);
        return "student-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model) {
        StudentModel studentModel = new StudentModel();
        model.addAttribute("sinhVienToiMuonTaoMoi", studentModel);
        return "create-student";
    }

    @PostMapping
    public String createNewStudent(@ModelAttribute("sinhVienToiMuonTaoMoi") @Valid StudentModel studentModel, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) { //@Valid - dữ liệu truyền vào phải chuẩn
            return "create-student";
        } else {
            studentService.saveStudent(studentModel);
            return "redirect:/students";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id) {
        studentService.delete(id);
        return "redirect:/students";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable("id") String id, Model model){
        StudentModel studentModel = studentService.findById(id);
        model.addAttribute("studentCapNhatMoi",studentModel);
        return "edit-student";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("studentCapNhatMoi") @Valid StudentModel studentModel, Errors errors){
        if (null != errors && errors.getErrorCount() > 0) { //@Valid - dữ liệu truyền vào phải chuẩn
            return "edit-student";
        } else {
            studentService.updateStudent(studentModel);
            return "redirect:/students";
        }
    }
}

