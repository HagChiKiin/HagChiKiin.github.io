package com.example.tim_kiem_viec_lam.controller.candidate;

import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.service.ApplicationService;
import com.example.tim_kiem_viec_lam.service.CandidateService;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    CandidateService candidateService;

    ApplicationService applicationService;

    UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable Long id, @RequestBody @Valid CandidateRequest request) {
        candidateService.updateCandidate(id, request);
        return ResponseEntity.ok(null);
    }

}
