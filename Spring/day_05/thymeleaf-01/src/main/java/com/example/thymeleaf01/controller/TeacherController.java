package com.example.thymeleaf01.controller;

import com.example.thymeleaf01.model.Teacher;
import com.example.thymeleaf01.request.Update;
import com.example.thymeleaf01.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    public TeacherService teacherService;

    @GetMapping
    public String getTeachers(Model model) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("danhSachGiaoVien", teachers);
        return "teacher-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model, Teacher teacher) {
        model.addAttribute("giaoVienToiMuonTaoMoi", teacher);
        return "create-teacher";
    }

    @PostMapping
    public String createNewTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @PutMapping("/modify")
    public String modifyListTeacher(@ModelAttribute("teacher") Teacher teacher, Update upd, @PathVariable int id, Model model) {
        teacher.setId(id);
        teacherService.updateTeacher(teacher, upd, id);
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("danhSachSuaGiaoVien", teachers);
        return "redirect:/teacher";
    }

    @DeleteMapping("delete")
    public String deleteTeacher(@PathVariable int id, Model model) {
        teacherService.deleteTeacher(id);
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("danhSachXoaGiaoVien", teachers);
        return "redirect:/teacher";
    }

}
