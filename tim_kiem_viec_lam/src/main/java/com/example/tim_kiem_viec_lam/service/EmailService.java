package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Otp;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.repository.OtpRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@EnableAsync
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    UserRepository userRepository;

    OtpRepository otpRepository;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender javaMailSender, UserRepository userRepository,OtpRepository otpRepository) {
        this.javaMailSender = javaMailSender;
        this.userRepository =userRepository;
        this.otpRepository=otpRepository;
    }

    @Async
    public void sendActivationEmail(String email,Long id) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setTo(email);

            helper.setSubject("[Tech Job] Active account");
            String activationLink = "http://localhost:8080/api/v1/users/" + id + "/activations";
            String emailContent = "Bạn vừa đăng ký tài khoản, Ấn <a href=\"" + activationLink + "\">đây</a> để thực hiện kích hoạt tài khoản";
            helper.setText(emailContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }
    }

    @Async
    public void sendOtp(String email) {
        String otpCode = UUID.randomUUID().toString();
        Optional<User> emailOptional = userRepository.findByEmail(email);

        otpRepository.save(Otp.builder()
                .otpCode(otpCode)
                .user(emailOptional.get())
                .expiredAt(LocalDateTime.now().plusMinutes(10))
                .build());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email);

            mimeMessageHelper.setSubject("[Tech Job] Reset password");

            String resetLink = "http://localhost:8080/check-otp-reset?otpCode=" + otpCode;
            String htmlContent = "<html> Bạn đã quên mật khẩu? <a href=\"" + resetLink + "\">Reset password.</a> </html>\n";
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }

    }

    @Async
    public void sendInterviewInvitationEmail(String candidateEmail, String jobTitle, String company,String name, String recruiterEmail, String recruiterPhone) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setTo(candidateEmail);

            helper.setSubject(company + " - Lời Mời Phỏng Vấn");

            String emailContent = "<html><body>" +
                    "<p>Chào bạn<strong> " + name.toUpperCase() + "</strong></p>" +
                    "<p>Bạn đã được mời tham gia phỏng vấn cho vị trí công việc: <strong>" + jobTitle + "</strong>. Vui lòng liên hệ với chúng tôi" +
                    " để sắp xếp thời gian, địa điểm, và hình thức phỏng vấn.</p>" +
                    "<p>Email liên hệ: <strong>" + recruiterEmail + "</strong><p>" +
                    "<p>Sđt liên hệ: <strong>" + recruiterPhone + "</strong><p>" +
                    "<p><strong>Trân trọng</strong></p>" +
                    "</body></html>";

            helper.setText(emailContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Lỗi khi gửi email!!!");
            e.printStackTrace();
        }
    }
}
