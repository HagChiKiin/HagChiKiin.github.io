package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Topic;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.service.CourseService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CourseAdminController {
    private final CourseService courseService;
    private final TopicService topicService;

    private final List<Course> courses;

    @GetMapping("/")
    public String getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize);
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        model.addAttribute("topicList", topicList);
        model.addAttribute("courses", courses);
        return "course-list";
    }

    @GetMapping("/admin/courses/create")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new UpsertCourseRequest());
        return "course-create";
    }

    @GetMapping("/admin/courses/{id}")
    public String getDetailCourse(@PathVariable Integer id, Model model) {
        Course course = courseService.getCourseDetail(id);
        model.addAttribute("course", course);
        return "course-edit";
    }


    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<Course> createCourse(@RequestBody UpsertCourseRequest request) {
        Course createdCourse = courseService.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Integer id, @RequestBody UpsertCourseRequest request) {
        Course updatedCourse = courseService.updateCourse(id, request);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


}
