package com.example.tim_kiem_viec_lam.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequest {

    @Email
    @NotBlank
    @Size(max = 255)
    String email;

    @NotBlank
    @Size(max = 255)
    String fullname;

    @NotNull
    String phone;

    @NotBlank
    String password;

}
