package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecruiterRequest {

    Long id;

    String address;

    String introduce;

    String contactInfo;

    String avatar;

    String phone;

    String name;

    String status;

}
