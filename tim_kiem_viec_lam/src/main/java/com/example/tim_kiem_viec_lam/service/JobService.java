package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.JobRequest;
import com.example.tim_kiem_viec_lam.model.response.JobResponse;
import com.example.tim_kiem_viec_lam.repository.ApplicationRepository;
import com.example.tim_kiem_viec_lam.repository.JobRepository;
import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JobService {

    ObjectMapper objectMapper;

    JobRepository jobRepository;

    ApplicationRepository applicationRepository;

    List<Job> jobs;

    public List<Job> getAllJob() {
        return jobRepository.findAll();
    }

    public JobResponse saveJob(JobRequest jobRequest) {
        Job job = objectMapper.convertValue(jobRequest, Job.class);
        jobRepository.save(job);
        return objectMapper.convertValue(job, JobResponse.class);
    }

    public JobResponse updateJob(Long id, JobRequest jobRequest) throws NotFoundException {
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
        job.setYoeFrom(jobRequest.getYoeFrom());
        job.setYoeTo(jobRequest.getYoeTo());

        jobRepository.save(job);

        return objectMapper.convertValue(job, JobResponse.class);
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
