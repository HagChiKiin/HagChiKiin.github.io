package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.Candidate;
import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.exception.NotFoundException;
import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.repository.CandidateRepository;
import com.example.tim_kiem_viec_lam.repository.RecruiterRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.statics.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {

    ObjectMapper objectMapper;

    UserRepository userRepository;

    CandidateRepository candidateRepository;

    public void createCandidate(CandidateRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userRepository.findById(customUserDetails.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + request.getId());
                });
        Candidate candidate = Candidate.builder()
                .user(user)
                .name(request.getName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .experience(request.getExperience())
                .avatar(request.getAvatar())
                .dob(request.getDob())
                .gender(Gender.valueOf(request.getGender()))
                .build();
        candidateRepository.save(candidate);
    }

    public void updateCandidate(Long id, CandidateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + request.getId());
                });
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Not found candidate"));
        candidate.setUser(user);
        candidate.setName(request.getName());
        candidate.setAddress(request.getAddress());
        candidate.setDob(request.getDob());
        candidate.setSkill(request.getSkill());
        candidate.setAvatar(request.getAvatar());
        candidate.setPhone(request.getPhone());
        candidate.setExperience(request.getExperience());
        candidate.setGender(Gender.valueOf(request.getGender()));

        candidateRepository.save(candidate);
    }


    public Candidate getCandidateById(Long id){
        return candidateRepository.findByUserId(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + id);
                });
    }

    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

//    public void createOrUpdateCandidate(CandidateRequest request, Long id) {
//        Optional<Candidate> existingCandidate = candidateRepository.findByUserId(id);
//
//        Candidate candidate;
//        if (existingCandidate.isPresent()) {
//            candidate = existingCandidate.get();
//            candidate.setName(request.getName());
//            candidate.setAddress(request.getAddress());
//            candidate.setDob(request.getDob());
//            candidate.setSkill(request.getSkill());
//            candidate.setAvatar(request.getAvatar());
//            candidate.setPhone(request.getPhone());
//            candidate.setExperience(request.getExperience());
//            candidate.setGender(Gender.valueOf(request.getGender()));
//
//        } else {
//
//            candidate = Candidate.builder()
//                    .name(request.getName())
//                    .address(request.getAddress())
//                    .avatar(request.getAvatar())
//                    .phone(request.getPhone())
//                    .experience(request.getExperience())
//                    .dob(request.getDob())
//                    .gender(Gender.valueOf(request.getGender()))
//                    .build();
//        }
//        candidateRepository.save(candidate);
//    }
}

