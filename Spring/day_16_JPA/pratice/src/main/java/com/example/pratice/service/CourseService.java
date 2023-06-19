package com.example.pratice.service;

import com.example.pratice.entity.Course;
import com.example.pratice.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseService {

    private  final CourseRepository courseRepository;


    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
