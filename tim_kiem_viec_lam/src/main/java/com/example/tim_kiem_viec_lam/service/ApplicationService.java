package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.ApplicationRequest;
import com.example.tim_kiem_viec_lam.repository.ApplicationRepository;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService {

    ApplicationRepository applicationRepository;

    JobRepository jobRepository;

    UserRepository userRepository;

    public void createApplication(ApplicationRequest request, Job job) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userRepository.findById(customUserDetails.getId())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy người dùng"));

        Application application = Application.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .description(request.getDescription())
                .email(request.getEmail())
                .cv(request.getCv())
                .job(job)
                .user(user)
                .applicationStatus(ApplicationStatus.NOT_REVIEW)
                .applicationTime(LocalDate.now())
                .build();
        applicationRepository.save(application);
    }


    public Application updateApplicationStatus(Long id, String newStatus) {
        Application application = applicationRepository.findById(id).orElse(null);

        if (application == null) {
            throw new NotFoundException("Không tìm thấy ứng viên với ID: " + id);
        }

        application.setApplicationStatus(ApplicationStatus.valueOf(newStatus));
        applicationRepository.save(application);
        return application;
    }

    public Long countApplicationsByUserId(Long userId) {
        return applicationRepository.countByUserId(userId);
    }


    public List<Application> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByUserId(userId);
    }
}
