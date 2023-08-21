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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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

    @PostMapping("/update-status/{id}")
    public ResponseEntity<?> updateApplicationStatus( @RequestParam("status") String status, @PathVariable Long id) {

        try {
            applicationService.updateApplicationStatus(id, status);
            return ResponseEntity.ok("Cập nhật trạng thái thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi cập nhật trạng thái");
        }
    }

}
