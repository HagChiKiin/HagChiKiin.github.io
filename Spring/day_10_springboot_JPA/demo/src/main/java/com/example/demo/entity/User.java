package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="email", nullable = false, unique = true )
    private String email;

    @Column(name="fullname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String fullname;


    @Column(name="dob")
    private LocalDate birthday;

    @Column(name = "status")
    private Boolean status;
}
