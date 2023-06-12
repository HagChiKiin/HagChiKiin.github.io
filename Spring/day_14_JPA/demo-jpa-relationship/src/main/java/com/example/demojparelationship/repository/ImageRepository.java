package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}