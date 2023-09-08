package com.example.tim_kiem_viec_lam.model.response;

import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    Long id;

    String companyName;

    String avatar;

    String location;

    String title;

    String detail;

        double yoe;

    Literacy literacy;

    WorkType workType;

    String benefit;

    Integer salaryTo;

    Integer salaryFrom;

    String requirement;

    List<String> skill;

    JobStatus jobStatus;

    LocalDateTime publishDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dueDateTime;

    LocalDateTime closeDateTime;

}
