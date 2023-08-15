package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.ApplicationRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.repository.ApplicationRepository;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
                .build();
        applicationRepository.save(application);
    }

    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

}
