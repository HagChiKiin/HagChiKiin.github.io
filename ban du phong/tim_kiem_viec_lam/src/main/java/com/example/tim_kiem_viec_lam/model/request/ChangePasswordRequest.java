package com.example.tim_kiem_viec_lam.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordRequest {
    @Email
    @NotBlank
    @Size(max = 255)
    String email;

    @NotBlank
    String otpCode;

    @NotBlank
    String oldPassword;

    @NotBlank
    String newPassword;
}
