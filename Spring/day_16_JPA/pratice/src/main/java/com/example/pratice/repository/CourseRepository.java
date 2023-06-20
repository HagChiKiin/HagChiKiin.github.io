package com.example.pratice.repository;

import com.example.pratice.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from course",
            countQuery = "select count(id) from course"
    )
    Page<Course> getAllCourse(String name, Pageable pageable);
}
