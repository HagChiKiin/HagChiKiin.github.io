package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobRequest {

    Long id;

    LocalDateTime createdDateTime;

    String createdBy;

    LocalDateTime lastModifiedDateTime;

    String lastModifiedBy;

    Recruiter recruiter;

    String location;

    String title;

    String detail;

    int yoeFrom;

    int yoeTo;

    Literacy literacy;

    WorkType workType;

    String benefit;

    String salaryFrom;

    String salaryTo;

    JobStatus jobStatus;

    LocalDateTime publishDateTime;

    LocalDateTime dueDateTime;

    LocalDateTime closeDateTime;


    LocalDateTime deletedDateTime;

}
