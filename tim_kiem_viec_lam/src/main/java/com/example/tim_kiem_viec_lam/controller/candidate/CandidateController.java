package com.example.tim_kiem_viec_lam.controller.candidate;

import com.example.tim_kiem_viec_lam.model.request.CandidateRequest;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    CandidateService candidateService;

    @PostMapping
    public ResponseEntity<?> createCandidate(@RequestBody CandidateRequest request) {
        candidateService.createCandidate(request);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable Long id, @RequestBody @Valid CandidateRequest request) {
        candidateService.updateCandidate(id, request);
        return ResponseEntity.ok(null);
    }
}
