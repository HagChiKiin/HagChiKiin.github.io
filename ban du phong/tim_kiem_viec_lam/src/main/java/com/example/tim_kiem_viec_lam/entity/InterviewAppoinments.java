package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.InterviewResult;
import com.example.tim_kiem_viec_lam.statics.InterviewType;
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
public class InterviewAppoinments extends  BaseEntity {
    @ManyToOne(targetEntity = Application.class)
    @JoinColumn(name = "application_id")
    Application application;

    @Column(name = "interview_type")
    @Enumerated(EnumType.STRING)
    InterviewType interviewType;

    @Column(name = "interview_date")
    LocalDateTime interviewDate;

    @Column(name = "interview_link")
    String interviewLink;

    @Column(name = "interview_result")
    @Enumerated(EnumType.STRING)
    InterviewResult interviewResult;

    @Column(name = "feedback")
    String feedback;

    @Column(name = "deleted_datetime")
    LocalDateTime deletedDateTime;

}
