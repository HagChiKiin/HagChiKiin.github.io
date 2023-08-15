package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationRequest {

    Long id;

    Long jobId;

    String name;

    String cv;

    String phone;

    String email;

    String description;
}
