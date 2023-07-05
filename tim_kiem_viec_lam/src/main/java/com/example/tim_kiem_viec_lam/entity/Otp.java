package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otps")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Otp extends BaseEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "otp_code")
    String otpCode;

}
