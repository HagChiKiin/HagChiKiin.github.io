package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.entity.*;
import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.model.response.UserResponse;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.service.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {

    JobService jobService;

    RecruiterService recruiterService;

    FileService fileService;

    CandidateService candidateService;

    UserService userService;


    @GetMapping("/")
    public String getAll(Model model ) {
        List<Job> jobList = jobService.getAllJob();
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        List<FileEntity> fileList = fileService.getAllFile();
        // TODO: ko biết lấy ra id của user đang đăng nhập để truyền vào phần html thông tin cá nhân
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//
        model.addAttribute("users", customUserDetails.getId());
        model.addAttribute("recruiterList", recruiterList);
        model.addAttribute("jobList", jobList);
        model.addAttribute("fileList", fileList);
        return "user/index";
    }

    @GetMapping("admin/companies")
    public String getAdmin(Model model) {
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList", recruiterList);
        return "admin/company-list";
    }


    @GetMapping("/admin/companies-create")
    public String getCompany() {
        return "admin/company-create";

    }

    @GetMapping("/recruiter/jobs")
    public String getJob(Model model, @RequestParam String email) {
        // Cắt chuỗi email để loại bỏ phần (.com)
        int atIndex = email.indexOf(".");
        if (atIndex != -1) {
            email = email.substring(0, atIndex);
        }
        List<Job> jobList = jobService.getAllJobByRecruiter(email);
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList", recruiterList);
        model.addAttribute("jobList", jobList);
        return "admin/job-list";

    }

    @GetMapping("/recruiter/jobs/{id}")
    public String getDetailJob(@PathVariable Long id, Model model) {
        List<Job> jobList = jobService.getAllJob();
        Job job = jobService.getJobById(id);
        model.addAttribute("jobList", jobList);
        model.addAttribute("job", job);
        return "admin/job-edit";

    }

    @GetMapping("/recruiter/jobs-create")
    public String createJob(Model model) {
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        model.addAttribute("recruiterList", recruiterList);
        return "admin/job-create";
    }

    @GetMapping("/jd-page/{id}")
    public String getJobDetail(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "user/jd-page";
    }

    @GetMapping("/register-employees")
    public String registerCandidate() {
        return "user/register-employees";
    }

    @GetMapping("/register-employers")
    public String registerRecruiter() {
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
    public String loginEmployer() {
        return "recruiter/login-employers";
    }

    @GetMapping("/recruiter/published-recruitment")
    public String publishRecruitment() {
        return "recruiter/published-recruitment";
    }

    @GetMapping("/candidate/info/{id}")
    public String getInfoCandidate(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        List<Candidate> candidate = candidateService.getAllCandidate();
        model.addAttribute("user",user);
        model.addAttribute("candidate",candidate);
        return "candidate/candidate-info";
    }

    @GetMapping("/splash")
    public String showSplashPage() {
        return "user/splash-page"; // Trang trung gian (splash page)
    }


    @GetMapping("/search")
    @ResponseBody
    public CommonResponse<?> searchBook(JobSearchRequest request) {
        return jobService.searchJob(request);
    }
}
