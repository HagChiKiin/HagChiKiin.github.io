package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Supporter;
import com.example.demo.model.Topic;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.service.CourseService;
import com.example.demo.service.SupporterService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class CourseAdminController {
    private final CourseService courseService;
    private final TopicService topicService;
    private final SupporterService supporterService;

    private final List<Course> courses;

    // Danh sách View
    @GetMapping("/")
    public String getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize);
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "course-list";
    }

    @GetMapping("/admin/courses/create")
    public String createForm(Model model) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter>supporterList=supporterService.getAllSupporter();
        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);
        return "course-create";
    }

    @GetMapping("/admin/courses/{id}")
    public String getDetailCourse(@PathVariable Integer id, Model model) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter>supporterList=supporterService.getAllSupporter();
        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);
        model.addAttribute("courseId",id);
        return "course-edit";

    }


    // Danh sách API
    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<?> createCourse(@RequestBody @Valid  UpsertCourseRequest request) {
        Course createdCourse = courseService.createCourse(request);
        return ResponseEntity.ok(createdCourse);
    }

    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody @Valid UpsertCourseRequest request) {
        Course updatedCourse = courseService.updateCourse(id, request);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


}
