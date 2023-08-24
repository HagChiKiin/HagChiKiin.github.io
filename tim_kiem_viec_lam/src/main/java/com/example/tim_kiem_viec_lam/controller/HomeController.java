package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.entity.*;
import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.security.SecurityUtils;
import com.example.tim_kiem_viec_lam.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    ObjectMapper objectMapper;

    ApplicationService applicationService;


    @GetMapping("/")
    public String getAll(Model model) {
        List<Job> jobList = jobService.getAllJob();
        List<Job> jobListBySalary = jobService.getJobSortHighestSalary();
        List<Job> jobListByNewest = jobService.getNewestJobs();
        List<Job> jobListAttractive = jobService.getAttractiveJobs();
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
        List<FileEntity> fileList = fileService.getAllFile();
        List<Recruiter> topRecruiterList = recruiterService.gettopRecruiterList();

        Optional<Long> currentUserLoginId = SecurityUtils.getCurrentUserLoginId();
        currentUserLoginId.ifPresent(aLong -> model.addAttribute("users", aLong));

        if (currentUserLoginId.isPresent()) {
            Long userId = currentUserLoginId.get();
            Candidate candidate = candidateService.getCandidateByUserId(userId);
            model.addAttribute("candidate", candidate);
        }

        model.addAttribute("recruiterList", recruiterList);
        model.addAttribute("topRecruiterList", topRecruiterList);
        model.addAttribute("jobList", jobList);
        model.addAttribute("jobListBySalary", jobListBySalary);
        model.addAttribute("jobListByNewest", jobListByNewest);
        model.addAttribute("jobListAttractive", jobListAttractive);
        model.addAttribute("fileList", fileList);


        return "user/index";
    }

    @GetMapping("/admin/companies")
    public String getCompanyByAdmin(@RequestParam(required = false, defaultValue = "1") int  page,
                                    @RequestParam(required = false, defaultValue = "6") int  pageSize,
                                    Model model) {

        Page<Recruiter> companyPage  = recruiterService.getRecruiters(page,pageSize);
        List<Recruiter> recruiterList = recruiterService.getAllRecruiter();
//        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageInfo", companyPage );
        model.addAttribute("currentPage", page);
        model.addAttribute("recruiterList", recruiterList);
        return "admin/company-list";
    }


    @GetMapping("/admin/companies/{id}")
    public String updateCompanyByAdmin(@PathVariable Long id, Model model) {
        Recruiter recruiter = recruiterService.getRecruiterById(id);
        model.addAttribute("recruiter", recruiter);
        return "admin/company-edit";

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
        Job job = jobService.getJobById(id);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        model.addAttribute("job", job);
        try {
            model.addAttribute("applications", ow.writeValueAsString(job.getApplications()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
        String jobSkill = job.getSkill();
        List<Job> SimilarListJob = jobService.getSimilarJob(jobSkill, id);
        model.addAttribute("SimilarListJob", SimilarListJob);
        model.addAttribute("application", job.getApplications());
        job.setApplications(null);
        model.addAttribute("job", job);

        return "user/jd-page";
    }

    @GetMapping("/change-password")
    public String editProfile(Model model) {

        return "user/change-password";
    }

    @GetMapping("/register-employees")
    public String registerCandidate() {
        return "user/register-employees";
    }

    @GetMapping("/register-employers")
    public String registerRecruiter() {
        return "user/register-employers";
    }

    @GetMapping("/login-employees")
    public String loginEmployee() {
        return "candidate/login-employees";
    }

    @GetMapping("/login-employers")
    public String loginEmployer() {
        return "recruiter/login-employers";
    }

    @GetMapping("/candidate/info/{id}")
    public String getInfoCandidate(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        Candidate candidate = candidateService.getCandidateByUserId(id);
        model.addAttribute("users", user);
        model.addAttribute("candidate", candidate);

        Long countApplications = applicationService.countApplicationsByUserId(id);
        model.addAttribute("countApplications", countApplications);

        return "candidate/candidate-info";
    }

    @GetMapping("/applications/{userId}")
    public String getApplications(@PathVariable Long userId, Model model) {
        Optional<Long> currentUserLoginId = SecurityUtils.getCurrentUserLoginId();
        currentUserLoginId.ifPresent(aLong -> model.addAttribute("users", aLong));
        List<Application> applications = applicationService.getApplicationsByUserId(userId);
        model.addAttribute("applications", applications);
        return "candidate/application"; // Tên template HTML của bạn
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
