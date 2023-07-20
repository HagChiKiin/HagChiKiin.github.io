package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otpVerifications")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpVerification extends BaseEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Otp.class)
    @JoinColumn(name = "otp_id")
    Otp otp;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean sucsess;

    @Column(name = "number_of_verification")
    int numberOfVerification;

}
