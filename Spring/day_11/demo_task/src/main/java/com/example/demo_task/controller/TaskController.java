package com.example.demo_task.controller;

import com.example.demo_task.model.request.TaskRequest;
import com.example.demo_task.model.responce.TaskResponse;
import com.example.demo_task.service.StatusService;
import com.example.demo_task.service.TaskService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {
    TaskService taskService;

   StatusService statusService;

    @GetMapping("/")
    public String getTasks(Model model) {
            List<TaskResponse> taskResponses = taskService.getAll();
        model.addAttribute("tasks", taskResponses);
        return "index";
    }

    @GetMapping("api/v1/tasks/status")
    public ResponseEntity<?> getStatus(){
        return ResponseEntity.ok(statusService.getStatus());
    }

    @GetMapping("/api/v1/tasks{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.getDetail(id));
    }

    @PostMapping("/api/v1/tasks")
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskRequest request  ){
        taskService.saveTask(request);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/api/v1/tasks{id}")
    public ResponseEntity<?> updateTask(@RequestBody @Valid TaskRequest request ){
        taskService.saveTask(request);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/api/v1/tasks{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id){
        taskService.delete(id);
        return ResponseEntity.ok(null);
    }
}
