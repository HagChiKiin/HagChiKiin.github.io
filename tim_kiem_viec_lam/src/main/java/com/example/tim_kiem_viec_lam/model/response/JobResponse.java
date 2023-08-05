package com.example.tim_kiem_viec_lam.model.response;

import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    Long id;

    String avatar;

    String location;

    String title;

    String detail;

    int yoeFrom;

    int yoeTo;

    Literacy literacy;

    WorkType workType;

    String benefit;

    String salaryTo;

    String salaryFrom;

    String requirement;

    List<String> skill;

    JobStatus jobStatus;

    LocalDateTime publishDateTime;

    LocalDateTime dueDateTime;

    LocalDateTime closeDateTime;


}
