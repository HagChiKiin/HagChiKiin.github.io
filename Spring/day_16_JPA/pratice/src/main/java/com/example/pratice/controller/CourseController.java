package com.example.pratice.controller;

import com.example.pratice.entity.Course;
import com.example.pratice.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/")
    public String getUserPage(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "course-list";
    }
    @GetMapping("/onlab")
    public String getOnLab(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "course-onlab-list";
    }
    @GetMapping("/online")
    public String getOnLine(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "course-online-list";
    }

}