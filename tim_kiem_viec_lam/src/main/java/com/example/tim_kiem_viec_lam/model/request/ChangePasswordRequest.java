package com.example.tim_kiem_viec_lam.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordRequest {

    @NotBlank
    @Size(min = 6, message = "Password cũ phải tối thiểu 6 ký tự ")
    String currentPassword;

    @NotBlank
    @Size(min = 6, message = "Password mới phải tối thiểu 6 ký tự ")
    String newPassword;

    @NotBlank
    @Size(min = 6, message = "Nhập lại password mới phải tối thiểu 6 ký tự ")
    String rePassword;
}
