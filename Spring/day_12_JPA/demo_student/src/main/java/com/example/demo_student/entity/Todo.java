package com.example.demo_student.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "todo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "status")
    Boolean status;

}
