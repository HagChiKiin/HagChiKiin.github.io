package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.JobRequest;
import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.model.response.JobSearchResponse;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.repository.RecruiterRepository;
import com.example.tim_kiem_viec_lam.repository.custom.JobCustomRepository;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import com.example.tim_kiem_viec_lam.statics.JobStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobService {

    JobRepository jobRepository;


    RecruiterRepository recruiterRepository;


    JobCustomRepository jobCustomRepository;

    public List<Job> getAllJob() {
        return jobRepository.findAllExceptClosedAndLocked();
    }

    public List<Job> getJobSortHighestSalary() {
        List<Job> top10Jobs = jobRepository.findTop10ByHighestSalary();
        if (top10Jobs.size() > 10) {
            top10Jobs = top10Jobs.subList(0, 10);
        }
        return top10Jobs;
    }

    public List<Job> getNewestJobs() {
        List<Job> top16Jobs = jobRepository.findTop16ByNewestJobs();
        if (top16Jobs.size() > 16) {
            top16Jobs = top16Jobs.subList(0, 16);
        }
        return top16Jobs;
    }

    public List<Job> getAllJobByRecruiter(String email) {
        return jobRepository.findByRecruiterEmail(email);
    }

    public List<Job> getAttractiveJobs() {
        List<Job> top16Jobs = jobRepository.findTop16AttractiveJobs();
        if (top16Jobs.size() > 16) {
            top16Jobs = top16Jobs.subList(0, 16);
        }
        return top16Jobs;
    }

    public List<Job> getSimilarJob(String skill, Long jobId) {
        skill = StringUtils.isNotEmpty(skill)?skill.replace("[","").replace("]",""):skill;
        List<Job> top3Jobs = jobRepository.findRandomJobsBySkillAndExcludeCurrentJob(skill, jobId);
        if (top3Jobs.size() > 3) {
            top3Jobs = top3Jobs.subList(0, 3);
        }
        return top3Jobs;
    }

    public List<Job> getJobsByRecruiter(Recruiter recruiter, Long id) {
        return jobRepository.findJobsByRecruiter(recruiter, id);
    }

    public void createJob(JobRequest jobRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Recruiter recruiter = recruiterRepository.findByUserId(customUserDetails.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + jobRequest.getId());
                });
        Job job = Job.builder()
                .jobStatus(jobRequest.getJobStatus())
                .benefit(jobRequest.getBenefit())
                .detail(jobRequest.getDetail())
                .closeDateTime(jobRequest.getCloseDateTime())
                .deletedDateTime(jobRequest.getDeletedDateTime())
                .dueDateTime(jobRequest.getDueDateTime())
                .literacy(jobRequest.getLiteracy())
                .location(jobRequest.getLocation())
                .publishDateTime(jobRequest.getPublishDateTime())
                .recruiter(recruiter)
                .salaryFrom(jobRequest.getSalaryFrom())
                .salaryTo(jobRequest.getSalaryTo())
                .skill(String.valueOf(jobRequest.getSkill()))
                .title(jobRequest.getTitle())
                .workType(jobRequest.getWorkType())
                .requirement(jobRequest.getRequirement())
                .yoe(jobRequest.getYoe())
                .build();
        jobRepository.save(job);
    }

    public void updateJob(Long id, JobRequest jobRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Recruiter recruiter = recruiterRepository.findByUserId(customUserDetails.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + jobRequest.getId());
                });
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found job with id = " + id);
                });

        job.setBenefit(jobRequest.getBenefit());
        job.setDetail(jobRequest.getDetail());
        job.setJobStatus(jobRequest.getJobStatus());
        job.setLiteracy(jobRequest.getLiteracy());
        job.setLocation(jobRequest.getLocation());
        job.setCloseDateTime(jobRequest.getCloseDateTime());
        job.setDueDateTime(jobRequest.getDueDateTime());
        job.setPublishDateTime(jobRequest.getPublishDateTime());
        job.setRequirement(jobRequest.getRequirement());
        job.setSalaryFrom(jobRequest.getSalaryFrom());
        job.setSalaryTo(jobRequest.getSalaryTo());
        job.setTitle(jobRequest.getTitle());
        job.setWorkType(jobRequest.getWorkType());
        job.setYoe(jobRequest.getYoe());
        job.setSkill("[" + String.join(", ", jobRequest.getSkill()) + "]");
        job.setRecruiter(recruiter);

        jobRepository.save(job);
    }

    public void deleteJob(Long id) throws NotFoundException {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found job")
                );
        jobRepository.delete(job);
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found job with id = " + id);
                });
    }

    public CommonResponse<?> searchJob(JobSearchRequest request) {
        List<JobSearchResponse> jobs = jobCustomRepository.searchJob(request);
        return CommonResponse.builder()
                .data(jobs)
                .build();
    }

    public void updateJobStatus(Long id, String status) {
        Job job = jobRepository.findById(id).orElse(null);

        if (job == null) {
            throw new NotFoundException("Không tìm thấy coogn việc với ID: " + id);
        }

        job.setJobStatus(JobStatus.valueOf(status));
        jobRepository.save(job);
    }


}
