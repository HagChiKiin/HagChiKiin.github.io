package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Otp;
import com.example.tim_kiem_viec_lam.model.response.OtpResponse;
import com.example.tim_kiem_viec_lam.repository.OtpRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpService {

    OtpRepository otpRepository;

    ObjectMapper objectMapper;

    public String generateOTP() {
        StringBuilder otp = new StringBuilder();

        String OTP_CHARACTERS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(OTP_CHARACTERS.length());
            otp.append(OTP_CHARACTERS.charAt(index));
        }

        return otp.toString();
    }

    public OtpResponse verifyOtp(String otpCode) {
        Optional<Otp> optional=otpRepository.findByOtpCode(otpCode);
        if (optional.isPresent()){
            Otp otp=optional.get();
            return OtpResponse.builder()
                    .otpCode(otp.getOtpCode())
                    .expiredTime(otp.getExpiredTime())
                    .email(otp.getUser().getEmail())
                    .build();
        }
        return null;
    }

}
