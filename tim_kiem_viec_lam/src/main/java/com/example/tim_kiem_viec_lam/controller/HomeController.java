package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.service.JobService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {

    JobService jobService;

    @GetMapping("/")
    public String getAll(Model model){
        List<Job> jobList = jobService.getAllJob();
        model.addAttribute("jobList",jobList);
        return "user/index";
    }
    @GetMapping("admin/companies")
    public String getAdmin(){
        return "admin/company-list";
    }

    @GetMapping("/admin/companies-create")
    public String getCompany() {
        return "admin/company-create";

    }
    @GetMapping("/admin/jobs")
    public String getJob() {
        return "admin/job-list";

    }

    @GetMapping("/admin/jobs-create")
    public String createJob() {
        return "admin/job-create";
    }

    @GetMapping("/recruiter")
    public String getUser(){
        return "user/index-recruiter";
    }

    @GetMapping("/jd-page")
    public String getJobDetail(){
        return "user/jd-page";
    }

    @GetMapping("/search")
    public String searchJob(){
        return "user/search";
    }

    @GetMapping("/register-employees")
    public String registerCandidate(){
        return "user/register-employees";
    }

    @GetMapping("/register-employers")
    public String registerRecruiter(){
        return "user/register-employers";
    }

    @GetMapping("/candidate/job-search")
    public String getJobSearch() {
        return "candidate/job-search";
    }

    @GetMapping("/login-employees")
    public String loginEmployee() {
        return "candidate/login-employees";
    }

    @GetMapping("/login-employers")
    public String loginEmployer(){
        return "recruiter/login-employers";
    }

    @GetMapping("/recruiter/published-recruitment")
    public String publishRecruitment(){
        return "recruiter/published-recruitment";
    }
}
