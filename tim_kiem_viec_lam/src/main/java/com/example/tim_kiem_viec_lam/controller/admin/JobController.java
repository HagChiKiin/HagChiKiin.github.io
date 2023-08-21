package com.example.tim_kiem_viec_lam.controller.admin;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.model.request.JobRequest;
import com.example.tim_kiem_viec_lam.model.response.JobResponse;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.service.JobService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/jobs")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobController {

    JobService jobService;

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody JobRequest jobRequest) {
        jobService.createJob(jobRequest);
        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody @Valid JobRequest jobRequest) {
       jobService.updateJob(id, jobRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/update-status/{id}")
    public ResponseEntity<?> updateJobStatus( @RequestParam("status") String status, @PathVariable Long id) {

        try {
            jobService.updateJobStatus(id, status);
            return ResponseEntity.ok("Cập nhật trạng thái thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi cập nhật trạng thái");
        }
    }
}
