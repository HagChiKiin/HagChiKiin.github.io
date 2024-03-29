package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interviews")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application extends  BaseEntity {
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Job.class)
    @JoinColumn(name = "job_id")
    Job job;

    @Lob
    @Column(name = "cv", columnDefinition = "LONGBLOB")
    byte[] data;

    @Column(name = "application_time")
    LocalDateTime applicationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    ApplicationStatus applicationStatus;
}
