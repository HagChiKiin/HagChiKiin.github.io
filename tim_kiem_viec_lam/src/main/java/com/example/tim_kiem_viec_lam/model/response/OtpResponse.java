package com.example.tim_kiem_viec_lam.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpResponse {
    String otpCode;
    LocalDateTime expiredTime;
    String email;
}
