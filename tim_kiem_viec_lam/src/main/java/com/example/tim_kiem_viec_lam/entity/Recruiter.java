package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.RecruiterStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruiters")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recruiter extends BaseEntity {
    @OneToOne (targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "introduce")
    String introduce;

    @Column(name = "contact_info")
    String contactInfo;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "phone")
    String phone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    RecruiterStatus recruiterStatus;

    @OneToOne(targetEntity = FileEntity.class)
    @JoinColumn(name = "file_id")
    FileEntity fileId;

}
