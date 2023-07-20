package com.example.tim_kiem_viec_lam.model.response;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    Long id;

    Recruiter recruiter;

    String location;

    String title;


    String detail;


    int yoeFrom;


    int yoeTo;


    Literacy literacy;


    WorkType workType;


    String benefit;


    String salary;


    JobStatus jobStatus;


    LocalDateTime publishDateTime;


    LocalDateTime dueDateTime;


    LocalDateTime closeDateTime;


}
