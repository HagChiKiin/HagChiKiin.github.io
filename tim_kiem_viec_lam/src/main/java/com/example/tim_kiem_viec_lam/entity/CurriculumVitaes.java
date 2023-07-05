package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurriculumVitaes extends  BaseEntity{
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name")
    String name;

    @Column(name = "dob")
    String cvUrl;

    @Column(name = "deleted_datetime")
    LocalDateTime deletedDateTime;

}
