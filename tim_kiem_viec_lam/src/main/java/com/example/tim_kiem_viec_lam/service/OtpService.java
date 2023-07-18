package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.repository.OtpRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
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
import java.util.Random;


@Service
public class OtpService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    Random rd = new Random();

    @Autowired
    public OtpService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendOtp(String email) {
        // Creating a simple mail message
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        String randomOTP = String.valueOf(rd.nextInt(1000000));
        System.out.println(randomOTP);
        mailMessage.setText("Mã OTP của bạn là"+randomOTP+" \n\n Không chia sẻ mã này cho bất kỳ ai!");
        mailMessage.setSubject("[TECH JOB] OTP Vefification");

        // Sending the mail
        javaMailSender.send(mailMessage);
    }

    public void sendVerificationEmail(String email, String otpCode) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // Tạo đường dẫn xác nhận
        String confirmationLink = "http://localhost:8080/api/v1/authentication/verify?email=" + email + "&code=" + otpCode;

        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setSubject("Xác nhận đăng ký");
        mailMessage.setText("Vui lòng ấn vào liên kết sau để xác nhận đăng ký:" + confirmationLink);

        javaMailSender.send(mailMessage);
    }

    public void sendResetEmail(String email, String otpCode) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // Tạo đường dẫn xác nhận
        String resetPassLink = "http://localhost:8080/api/v1/authentication/reset-password?email=" + email + "&code=" + otpCode;

        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setSubject("Xác nhận đăng ký");
        mailMessage.setText("Vui lòng ấn vào liên kết sau để reset password:" + resetPassLink);

        javaMailSender.send(mailMessage);
    }

//    public void sendAttachedMail(String receiver) throws MessagingException {
//        // Creating a mime message
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper;
//
//        // Setting multipart as true for attachments to
//        // be send
//        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setFrom(sender);
//        mimeMessageHelper.setTo(receiver);
//        mimeMessageHelper.setText("Email có đính kèm file");
//        mimeMessageHelper.setSubject("Gửi mail kèm file");
//
//        // Adding the attachment
//        String filePath = "/path/to/attachment/file.png";
//        FileSystemResource file = new FileSystemResource(new File(filePath));
//        mimeMessageHelper.addAttachment(file.getFilename(), file);
//
//        // Sending the mail
//        javaMailSender.send(mimeMessage);
//    }

}
