package com.example.thymeleaf01.controller;

import com.example.thymeleaf01.model.Student;
import com.example.thymeleaf01.service.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService studentService1 = new StudentService();
        StudentService studentService2 = new StudentService();

        studentService1.createData();

        studentService2.createData();
        studentService2.getStudents().add(new Student());

        System.out.println(studentService1.getAlStudents());
        System.out.println(studentService2.getAlStudents());

    }

}
