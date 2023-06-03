package com.example.demo_student.controller;

import com.example.demo_student.entity.Todo;
import com.example.demo_student.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class TodoController {

    TodoRepository todoRepository;

    @GetMapping("/")
    public String getIndex(Model model){
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        Todo todo1 = new Todo(null, todo.getTitle(), false);
        todoRepository.save(todo1);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }
    @PutMapping("/api/v1/todos/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo , @PathVariable Integer id ) {
        // Kiểm tra id
        Todo todo1 = todoRepository.findById(id)
                .orElseThrow(()->{
                    throw new RuntimeException("Not found");
                });
        // Cập nhật
        todo1.setTitle(todo.getTitle());
        todo1.setStatus(todo.getStatus());
        todoRepository.save(todo1);
        return ResponseEntity.ok(todo1); //200
    }
    @DeleteMapping("/api/v1/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        // Kiểm tra id
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->{
                    throw new RuntimeException("Not found");
                });
        todoRepository.delete(todo);

        return ResponseEntity.noContent().build(); //204

    }


}
