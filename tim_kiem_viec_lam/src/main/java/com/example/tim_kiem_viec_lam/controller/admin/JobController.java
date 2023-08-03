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
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody @Valid JobRequest jobRequest) {
        Job updateJob = jobService.updateJob(id, jobRequest);
        if (updateJob != null) {
            return ResponseEntity.ok(updateJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



//    @DeleteMapping("{job_id}")
//    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
//        jobService.deleteJob(id);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/{job_id}/application")
    public ResponseEntity<?> applyToJob(@PathVariable("jobId") Long id, @RequestBody @Valid Application application ){
        jobService.applyToJob(id, application);
        return ResponseEntity.ok("Ứng tuyển vào công việc thành công");
    }
}
