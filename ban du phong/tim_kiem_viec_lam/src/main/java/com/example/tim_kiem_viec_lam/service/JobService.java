package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.JobRequest;
import com.example.tim_kiem_viec_lam.model.response.JobResponse;
import com.example.tim_kiem_viec_lam.repository.ApplicationRepository;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.repository.RecruiterRepository;
import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class JobService {

    ObjectMapper objectMapper;

    JobRepository jobRepository;

    ApplicationRepository applicationRepository;

    RecruiterRepository recruiterRepository;

    List<Job> jobs;

    public List<Job> getAllJob() {
        return jobRepository.findAll();
    }

    public void createJob(JobRequest jobRequest) {

//        Job job = objectMapper.convertValue(jobRequest, Job.class);
//        jobRepository.save(job);
//        return objectMapper.convertValue(job, JobResponse.class);
//        Recruiter recruiter = recruiterRepository.findById(jobRequest.getId())
//                .orElseThrow(() -> {
//                    throw new NotFoundException("Not found supporter with id = " + jobRequest.getId());
//                });
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
                .recruiter(jobRequest.getRecruiter())
                .salaryFrom(jobRequest.getSalaryFrom())
                .salaryTo(jobRequest.getSalaryTo())
                .skill(String.valueOf(jobRequest.getSkill()))
                .avatar(jobRequest.getAvatar())
                .title(jobRequest.getTitle())
                .workType(jobRequest.getWorkType())
                .yoe(jobRequest.getYoe())
                .build();
        jobRepository.save(job);
    }

    public void updateJob(Long id, JobRequest jobRequest) throws NotFoundException {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found job"));
        job.setBenefit(jobRequest.getBenefit());
        job.setDetail(jobRequest.getDetail());
        job.setJobStatus(jobRequest.getJobStatus());
        job.setLiteracy(jobRequest.getLiteracy());
        job.setLocation(jobRequest.getLocation());
        job.setCloseDateTime(jobRequest.getCloseDateTime());
        job.setDueDateTime(jobRequest.getDueDateTime());
        job.setPublishDateTime(jobRequest.getPublishDateTime());
        job.setRecruiter(jobRequest.getRecruiter());
        job.setSalaryFrom(jobRequest.getSalaryFrom());
        job.setSalaryTo(jobRequest.getSalaryTo());

        job.setTitle(jobRequest.getTitle());
        job.setWorkType(jobRequest.getWorkType());
        job.setYoe(jobRequest.getYoe());

        jobRepository.save(job);
    }

    public void deleteJob(Long id) throws NotFoundException {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found job")
                );
        jobRepository.delete(job);
    }

    public void applyToJob(Long id, Application application) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Công việc không tồn tại"));

        // Thiết lập thông tin ứng tuyển
        application.setJob(job);
        application.setApplicationTime(LocalDateTime.now());
        application.setApplicationStatus(ApplicationStatus.UNDER_REVIEW);

        // Lưu thông tin ứng tuyển
        applicationRepository.save(application);
    }
}
