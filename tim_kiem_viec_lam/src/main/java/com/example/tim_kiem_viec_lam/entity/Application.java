package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applications")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application extends BaseEntity {
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Job.class)
    @JoinColumn(name = "job_id")
    @JsonBackReference
    Job job;

    @Column(name = "cv")
    String cv;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "description")
    String description;

    @Column(name = "application_time")
    LocalDateTime applicationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    ApplicationStatus applicationStatus;
}
