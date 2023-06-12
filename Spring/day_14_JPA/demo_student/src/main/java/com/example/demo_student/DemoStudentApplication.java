package com.example.demo_student;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStudentApplication.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();

    }


}
