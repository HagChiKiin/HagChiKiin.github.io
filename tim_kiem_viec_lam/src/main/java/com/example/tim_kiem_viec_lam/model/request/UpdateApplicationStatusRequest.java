package com.example.tim_kiem_viec_lam.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateApplicationStatusRequest {

    LocalDateTime getInterviewTime;

    String getInterviewLocation;

    String status;
}
