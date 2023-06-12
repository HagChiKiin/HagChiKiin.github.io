package com.example.demojparelationship.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)  // mặc định là eager
    @JoinColumn(name = "card_id")
    private IdentityCard identityCard;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)   // mặc định là lazy
    private List<Post> post;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Image> images;

}