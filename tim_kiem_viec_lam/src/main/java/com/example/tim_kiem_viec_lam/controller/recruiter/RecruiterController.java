package com.example.tim_kiem_viec_lam.controller.recruiter;

import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {

    RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<?> createRecruiter(@RequestBody RecruiterRequest request) {
        recruiterService.createRecruiter(request);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{recruiter_id}")
    public ResponseEntity<?> updateRecruiter(@PathVariable Long recruiter_id, @RequestBody @Valid RecruiterRequest request) {
        recruiterService.updateRecruiter(recruiter_id, request);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{recruiter_id}")
    public ResponseEntity<?> deleteRecruiter(@PathVariable Long recruiter_id) {
        recruiterService.deleteRecruiter(recruiter_id);
        return ResponseEntity.noContent().build();
    }
}

