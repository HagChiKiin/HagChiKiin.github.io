package com.example.tim_kiem_viec_lam.controller.candidate;

import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.service.ApplicationService;
import com.example.tim_kiem_viec_lam.service.CandidateService;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/application")
public class ApplicationController {

    ApplicationService applicationService;

//
//    @PostMapping
//    public ResponseEntity<?> createApplication(@RequestBody RecruiterRequest request) {
//        applicationService.createApplication(request);
//        return ResponseEntity.ok(null);
//    }
}
