package com.example.tim_kiem_viec_lam.controller.recruiter;

import com.example.tim_kiem_viec_lam.model.request.JobRequest;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<?> createRecruiter(@RequestBody RecruiterRequest recruiterRequest) {
        recruiterService.createRecruiter(recruiterRequest);
        return ResponseEntity.ok(null);
    }
}

