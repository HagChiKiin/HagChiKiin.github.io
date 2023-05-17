package com.example.student_02.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    int id;
    String name;
    String address;
    String phone;

    LocalDate dob;
    float gpa;


}
