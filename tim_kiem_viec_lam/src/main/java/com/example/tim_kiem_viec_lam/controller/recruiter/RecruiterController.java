package com.example.tim_kiem_viec_lam.controller.recruiter;

import com.example.tim_kiem_viec_lam.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {
    @Autowired
    private JobRepository jobRepository;




}
