package com.example.demojparelationship.controller;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("api/v1/files")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    // 1. Xem file
    @GetMapping("{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        Image image = imageService.getImageById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData());    // xem file dựa vào getType và getData

        // lưu ở dạng image//png    image/jpg    application/pdf
    }

    // 2. Xóa file
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();  // trả về mã 204 - no content
    }
}
