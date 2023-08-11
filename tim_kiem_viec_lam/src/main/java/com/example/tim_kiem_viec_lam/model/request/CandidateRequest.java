package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateRequest {

    Long id;

    String address;

    User user;

    String name;

    String dob;

    String experience;

    String avatar;

    String phone;

    String skill;

    String gender;

}
