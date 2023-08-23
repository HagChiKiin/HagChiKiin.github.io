package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateRequest {

    Long id;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được quá 255 ký tự")
    String address;

    User user;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 100, message = "Tên không được quá 100 ký tự")
    String name;

    String dob;

    String experience;

    String avatar;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 15, message = "Số điện thoại phải có ít nhất 10 và tối đa 15 ký tự")
    String phone;

    String skill;

    @NotBlank(message = "Giới tính không được để trống")
    String gender;

}
