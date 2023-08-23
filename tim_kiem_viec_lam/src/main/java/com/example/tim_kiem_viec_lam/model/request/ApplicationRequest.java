package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationRequest {

    @NotBlank
    @Size(max = 100, message = "Tên không được để trống")
    String name;

    @NotBlank (message = "cv không được để trống")
    String cv;

    @NotBlank (message = "Số điện thoại không được để trống")
    String phone;

    @Email(message = "Địa chỉ email không hợp lệ")
    @NotBlank
    String email;

    String description;

}
