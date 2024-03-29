package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Application;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.model.response.JobSearchResponse;
import com.example.tim_kiem_viec_lam.model.response.RecruiterSearchResponse;
import com.example.tim_kiem_viec_lam.repository.RecruiterRepository;
import com.example.tim_kiem_viec_lam.repository.custom.JobCustomRepository;
import com.example.tim_kiem_viec_lam.repository.custom.RecruiterCustomRepository;
import com.example.tim_kiem_viec_lam.statics.ApplicationStatus;
import com.example.tim_kiem_viec_lam.statics.RecruiterStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecruiterService {

    ObjectMapper objectMapper;

    RecruiterRepository recruiterRepository;

    RecruiterCustomRepository recruiterCustomRepository;

    List<Job> jobs;

    public List<Recruiter> getAllRecruiter() {
        return recruiterRepository.findAll();
    }

    public Page<Recruiter> getRecruiters(int page, int pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return recruiterRepository.findAll(pageRequest);
    }

    public void createRecruiter(RecruiterRequest recruiterRequest) {
        Recruiter recruiter = Recruiter.builder()
                .name(recruiterRequest.getName())
                .address(recruiterRequest.getAddress())
                .introduce(recruiterRequest.getIntroduce())
                .phone(recruiterRequest.getPhone())
                .contactInfo(recruiterRequest.getContactInfo())
                .avatar(recruiterRequest.getAvatar())
                .recruiterStatus(RecruiterStatus.ACTIVE)
                .build();
        recruiterRepository.save(recruiter);
    }

    public void updateRecruiter(Long recruiter_id, RecruiterRequest request) {
        Recruiter recruiter = recruiterRepository.findById(recruiter_id)
                .orElseThrow(()-> new NotFoundException("Not found recruiter"));
        recruiter.setName(request.getName());
        recruiter.setAddress(request.getAddress());
        recruiter.setContactInfo(request.getContactInfo());
        recruiter.setIntroduce(request.getIntroduce());
        recruiter.setAvatar(request.getAvatar());
        recruiter.setRecruiterStatus(RecruiterStatus.valueOf(request.getStatus()));
        recruiter.setPhone(recruiter.getPhone());
      recruiterRepository.save(recruiter);
    }

    public void deleteRecruiter(Long recruiter_id) throws NotFoundException{
        Recruiter recruiter = recruiterRepository.findById(recruiter_id)
                .orElseThrow(() -> new NotFoundException("Not found job")
                );
        recruiterRepository.delete(recruiter);
    }

    public Recruiter getRecruiterById(Long id){
        return recruiterRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + id);
                });
    }

    public void updateRecruiterStatus(Long id, String status) {
        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);

        if (recruiter == null) {
            throw new NotFoundException("Không tìm thấy nhà tuyển dụng với ID: " + id);
        }

        recruiter.setRecruiterStatus(RecruiterStatus.valueOf(status));
        recruiterRepository.save(recruiter);

    }

    public List<Recruiter> gettopRecruiterList() {
        return recruiterRepository.findTopRecruitersWithMostJobs();

    }

    public CommonResponse<?> searchRecruiter(RecruiterSearchRequest request) {
        List<RecruiterSearchResponse> recruiters = recruiterCustomRepository.searchRecruiter(request);
        return CommonResponse.builder()
                .data(recruiters)
                .build();
    }

//    public List<Recruiter> getTopJob() {
//        return recruiterRepository.findTopByJob();
//    }
}

