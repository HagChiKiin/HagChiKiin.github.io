package com.example.tim_kiem_viec_lam.controller.candidate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class CandidateController {
    @GetMapping("/candidate/job-search")
    public String getJobSearch() {
        return "candidate/job-search";
    }

    @GetMapping("/login-employees")
    public String loginEmployee() {
        return "candidate/login-employees";
    }


}
