package com.example.tim_kiem_viec_lam.controller.recruiter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class RecruiterController {
    @GetMapping("/login-employers")
    public String loginEmployer(){
        return "recruiter/login-employers";
    }

    @GetMapping("/recruiter/published-recruitment")
    public String publishRecruitment(){
        return "recruiter/published-recruitment";
    }

}
