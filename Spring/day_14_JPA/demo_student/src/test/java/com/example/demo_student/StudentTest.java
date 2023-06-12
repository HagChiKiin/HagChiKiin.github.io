package com.example.demo_student;

import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_user(){
        for (int i = 0; i < 30; i++) {
            Student student = new Student(
                    null,
                    faker.name().fullName(),
                    faker.internet().emailAddress()
            );
            studentRepository.save(student);

        }
    }

    @Test
    void findAll_Pageable(){
        PageRequest request = PageRequest.of(0,10);
        Page<Student> page = studentRepository.findAll(request);

        page.getContent().forEach(System.out::println);

        PageRequest request1 = PageRequest.of(0,10);
        Page<Student> page1 = studentRepository.getAllStudent(request1);

        page1.getContent().forEach(System.out::println);
    }

    @Test
    void findAllName(){
        PageRequest request = PageRequest.of(0,10);
        Page<Student> page = studentRepository.findByNameContainingIgnoreCaseUsingNQ("k",request);
        Page<Student> page1 = studentRepository.findAll(PageRequest.of(0, 10, Sort.by("name").descending()));

        page.getContent().forEach(System.out::println);
        System.out.println("--------*--------------*-------------*----------*-----------");
        page1.getContent().forEach(System.out::println);


    }
}
