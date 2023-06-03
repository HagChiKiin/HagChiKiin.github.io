package com.example.demo_student.repository;

import com.example.demo_student.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // sử dụng method query
    // Tìm kiếm theo tên và phân trang

    Page<Student> findByName(String name, Pageable pageable);

    List<Student> findByNameOrderByNameDesc(String name);

    List<Student> findByName(String name, Sort sort);

    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Sử dụng natuve query
    @Query(nativeQuery = true, value = "SELECT * FROM  students", countQuery = "SELECT count(id) FROM students")
    Page<Student> getAllStudent( Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM students s WHERE LOWER(name) LIKE CONCAT('%', LOWER (?1), '%')",
    countQuery = "SELECT count(s.id) FROM students s WHERE LOWER(s.name) like CONCAT('%', LOWER (?1), '%') ")
    Page<Student> findByNameContainingIgnoreCaseUsingNQ(String name, Pageable pageable);

    @Query(value = "SELECT * FROM students WHERE name=?1 ORDER BY name DESC", nativeQuery = true)
    List<Student> findByNameSort(String name);

}
