package com.example.demojparelationship.service;

import com.example.demojparelationship.repository.ImageRepository;
import com.example.demojparelationship.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final UserRepository userRepository;

    public List<Image> getImagesOfUser(Integer id) {
        return imageRepository.findByUser_Id(id);
    }

    public Image uploadImage(Integer id, MultipartFile file) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found id");
                });

        // validate file
        // kiểm tra tên , đuôi file, dung lượng file( tối đa 2MB )

        // Save image
        try {
            Image image = Image.builder()
                    .type(file.getContentType())    // xem loại của ảnh
                    .data(file.getBytes())
                    .user(user)
                    .build();
            imageRepository.save(image);
            return image;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Image getImageById(Integer id){
        return imageRepository.findById(id)
                .orElseThrow(()->{
                    throw new RuntimeException("Not found id");
                });

    }

    public void deleteImage(Integer id){
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found id");
                });
        imageRepository.delete(image);
    }
}
