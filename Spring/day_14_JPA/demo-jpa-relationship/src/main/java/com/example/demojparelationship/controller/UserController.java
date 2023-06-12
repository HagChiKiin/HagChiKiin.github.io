package com.example.demojparelationship.controller;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.ImageRepository;
import com.example.demojparelationship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/")
    public String getUserPage(Model model) {
        // Code logic
        List<User> userList  = userRepository.findAll();
        model.addAttribute("users", userList );

        return "index";
    }


    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        // Code logic
        Optional<User> users = userRepository.findById(id);
        model.addAttribute("files", users);
        return "file";
    }

    // 2. Xem file
    @GetMapping("api/v1/files/{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        Optional<Image> file = imageRepository.findById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok(file);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // 3. Xoa file
    @DeleteMapping("api/v1/files/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        // Code logic
        Image file = imageRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found");
                });
        imageRepository.delete(file);
        return ResponseEntity.noContent().build();

    }
}
