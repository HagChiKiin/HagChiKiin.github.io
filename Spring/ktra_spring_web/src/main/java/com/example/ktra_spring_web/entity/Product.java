package com.example.ktra_spring_web.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer  id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "price")
    double price;

    @Column(name = "description")
    String description;

    @Column(name = "image")
    String image;

    //    @OneToMany(mappedBy = "product")
    //     List<Order> orders;
}
