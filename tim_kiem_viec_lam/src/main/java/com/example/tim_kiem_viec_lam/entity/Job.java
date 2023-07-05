package com.example.tim_kiem_viec_lam.entity;

import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job extends BaseEntity{
    @ManyToOne(targetEntity = Recruiter.class)
    @JoinColumn(name = "recruiter_id")
    Recruiter recruiter;

    @Column(name = "location")
    String location;

    @Column(name = "title")
    String title;

    @Column(name = "detail")
    String detail;

    @Column(name = "yoe_from")
    int yoeFrom;

    @Column(name = "yoe_to")
    int yoeTo;

    @Column(name = "literacy")
    @Enumerated(EnumType.STRING)
    Literacy literacy;

    @Column(name = "work_type")
    @Enumerated(EnumType.STRING)
    WorkType workType;

    @Column(name = "benefit")
    String benefit;

    @Column(name = "salary")
    String salary;

    @Column(name = "job_status")
    @Enumerated(EnumType.STRING)
    JobStatus jobStatus;

    @Column(name = "publish_datetime")
    LocalDateTime publishDateTime;

    @Column(name = "due_datetime")
    LocalDateTime dueDateTime;

    @Column(name = "close_datetime")
    LocalDateTime closeDateTime;

    @Column(name = "deleted_datetime")
    LocalDateTime deletedDateTime;

}