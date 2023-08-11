package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidate extends BaseEntity {
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "name")
    String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "dob")
    String dob;

    @Column(name = "phone")
    String phone;

    @Column(name = "experience")
    String experience;

    @Column(name = "skill")
    String skill;

    @Column(name = "address")
    String address;

    @OneToOne(targetEntity = FileEntity.class)
    @JoinColumn(name = "file_id")
    FileEntity fileId;

}
