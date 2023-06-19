package com.example.driver_security.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
@FieldDefaults(level = AccessLevel.PROTECTED)

public class Person  {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     String name;
     String address;
     String phone;
}
