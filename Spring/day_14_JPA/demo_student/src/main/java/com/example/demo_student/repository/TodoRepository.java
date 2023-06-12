package com.example.demo_student.repository;

import com.example.demo_student.entity.Student;
import com.example.demo_student.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository  extends JpaRepository<Todo, Integer> {

}
