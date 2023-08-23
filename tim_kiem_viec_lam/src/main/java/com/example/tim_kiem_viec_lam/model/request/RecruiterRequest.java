package com.example.tim_kiem_viec_lam.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecruiterRequest {

    Long id;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được quá 255 ký tự")
    String address;

    String introduce;

    @NotBlank(message = "Thông tin liên hệ không được để trống")
    String contactInfo;

    @NotBlank(message = "Avatar không được để trống")
    String avatar;

    @NotBlank(message = "Số điện thoại không được để trống")
    String phone;

    @NotBlank(message = "Tên công ty không được để trống")
    String name;

    String status;

}
