package com.example.tim_kiem_viec_lam.controller.candidate;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.model.request.ApplicationRequest;
import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.service.ApplicationService;
import com.example.tim_kiem_viec_lam.service.CandidateService;
import com.example.tim_kiem_viec_lam.service.JobService;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    ApplicationService applicationService;

    JobService jobService;

    @PostMapping("/{id}")
    public ResponseEntity<?> applyJob(@RequestBody ApplicationRequest request, @PathVariable Long id) {
        Job job = jobService.getJobById(id);
        applicationService.createApplication(request, job);
        return ResponseEntity.ok(null);
    }
}
