package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.service.JobService;
import com.example.tim_kiem_viec_lam.service.RecruiterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {

    JobService jobService;

    RecruiterService recruiterService;


    @GetMapping("/")
    public String getAll(Model model){
        List<Job> jobList = jobService.getAllJob();
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList",recruiterList);
        model.addAttribute("jobList",jobList);
        return "user/index";
    }
    @GetMapping("admin/companies")
    public String getAdmin(Model model){
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList",recruiterList);
        return "admin/company-list";
    }


    @GetMapping("/admin/companies-create")
    public String getCompany() {
        return "admin/company-create";

    }
    @GetMapping("/recruiter/jobs")
    public String getJob(Model model) {
        List<Job> jobList = jobService.getAllJob();
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList",recruiterList);
        model.addAttribute("jobList",jobList);
        return "admin/job-list";

    }
    @GetMapping("/recruiter/jobs/{id}")
    public String getDetailCourse(@PathVariable Integer id, Model model) {
        return "admin/job-edit";

    }



    @GetMapping("/recruiter/jobs-create")
    public String createJob(Model model) {
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList",recruiterList);
        return "admin/job-create";
    }

    @PutMapping("/recruiter/jobs-edit/{id}")
    public String updateJob() {
        return "admin/job-edit";
    }

//    @GetMapping("/recruiter")
//    public String getUser(){
//        return "user/index-recruiter";
//    }

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

    @GetMapping("/splash")
    public String showSplashPage() {
        return "user/splash-page"; // Trang trung gian (splash page)
    }
}
