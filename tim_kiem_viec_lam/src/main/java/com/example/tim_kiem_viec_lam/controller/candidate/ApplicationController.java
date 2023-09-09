package com.example.tim_kiem_viec_lam.controller.candidate;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.model.request.ApplicationRequest;
import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    ApplicationService applicationService;

    JobService jobService;

    EmailService emailService;

    UserService userService ;

    @PostMapping("/{id}")
    public ResponseEntity<?> applyJob(@RequestBody ApplicationRequest request, @PathVariable Long id) {
        Job job = jobService.getJobById(id);
        applicationService.createApplication(request, job);
        return ResponseEntity.ok(null);
    }

//    @PostMapping("/update-status/{id}")
//    public ResponseEntity<?> updateApplicationStatus(@RequestParam("status") String status, @PathVariable Long id) {
//        try {
//            Application updatedApplication = applicationService.updateApplicationStatus(id, status);
//
//            if ("INTERVIEW_SCHEDULED".equals(status)) {
//
//                // Nếu trạng thái được cập nhật thành "hẹn phỏng vấn", gửi email mời phỏng vấn
//                emailService.sendInterviewInvitationEmail(updatedApplication.getEmail(),
//                        updatedApplication.getJob().getTitle(), updatedApplication.getJob().getRecruiter().getName(),updatedApplication.getName(),
//                        updatedApplication.getJob().getRecruiter().getUser().getEmail(), updatedApplication.getJob().getRecruiter().getPhone()
//                ,updatedApplication.getInterviewTime(), updatedApplication.getInterviewLocation());
//            }
//
//            return ResponseEntity.ok("Cập nhật trạng thái thành công");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi cập nhật trạng thái");
//        }
//    }

    @PostMapping("/update-status/{id}")
    public ResponseEntity<?> updateApplicationStatus(
            @RequestParam("status") String status,
            @PathVariable Long id,
            @RequestParam(value = "interviewTime", required = false) String interviewTimeStr, // Chấp nhận chuỗi thời gian
            @RequestParam(value = "interviewLocation", required = false) String interviewLocation
    ) {
        try {
            Application updatedApplication;

            LocalDateTime interviewTime = null; // Khởi tạo một giá trị mặc định là null

            // Kiểm tra nếu trạng thái là "INTERVIEW_SCHEDULED" và interviewTimeStr không rỗng
            if ("INTERVIEW_SCHEDULED".equals(status) && interviewTimeStr != null && !interviewTimeStr.isEmpty()) {
                // Chuyển đổi chuỗi thời gian thành LocalDateTime
                interviewTime = LocalDateTime.parse(interviewTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }

            updatedApplication = applicationService.updateApplicationStatus(id, status, interviewTime, interviewLocation);

            if ("INTERVIEW_SCHEDULED".equals(status) && interviewTime != null) {
                // Nếu trạng thái được cập nhật thành "hẹn phỏng vấn" và interviewTime không null, gửi email mời phỏng vấn
                emailService.sendInterviewInvitationEmail(
                        updatedApplication.getEmail(),
                        updatedApplication.getJob().getTitle(),
                        updatedApplication.getJob().getRecruiter().getName(),
                        updatedApplication.getName(),
                        updatedApplication.getJob().getRecruiter().getUser().getEmail(),
                        updatedApplication.getJob().getRecruiter().getPhone(),
                        updatedApplication.getInterviewTime(),
                        updatedApplication.getInterviewLocation()
                );
            } else if ("REJECTED".equals(status)) {
                // Gửi email thông báo từ chối ứng viên khi trạng thái là "REJECTED"
                emailService.sendRejectionEmail(
                        updatedApplication.getEmail(),
                        updatedApplication.getJob().getTitle(),
                        updatedApplication.getJob().getRecruiter().getName(),
                        updatedApplication.getName()
                );
            }

            return ResponseEntity.ok("Cập nhật trạng thái thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi cập nhật trạng thái");
        }
    }


}
