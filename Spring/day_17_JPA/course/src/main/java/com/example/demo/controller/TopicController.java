package com.example.demo.controller;


import com.example.demo.model.Course;
import com.example.demo.model.Topic;
import com.example.demo.model.request.TopicRequest;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    // Danh sách View
    @GetMapping("/topics")
    public String getAllTopic(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                               Model model) {
        Page<Topic> topicPage = topicService.getAll(page , pageSize);

        model.addAttribute("topic", topicPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("topicTaoMoi", new TopicRequest());
        return "topic-list";
    }

    // Danh sách API
    @PostMapping("/api/v1/admin/topics")
    public ResponseEntity<?> createTopic( @RequestBody @Valid TopicRequest request) {
        Topic createdTopic = topicService.createTopic(request);
        return ResponseEntity.ok(createdTopic);
    }

    @PutMapping("/api/v1/admin/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Integer id, @RequestBody @Valid TopicRequest request) {
        Topic updatedTopic = topicService.updateTopic(id, request);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/api/v1/admin/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
