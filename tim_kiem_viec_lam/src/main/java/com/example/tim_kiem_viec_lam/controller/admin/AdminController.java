package com.example.tim_kiem_viec_lam.controller.admin;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.repository.RecruiterRepository;
import com.example.tim_kiem_viec_lam.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/companies")
public class AdminController {

    RecruiterService recruiterService;

    RecruiterRepository recruiterRepository;

    @PostMapping("/update-status/{id}")
    public ResponseEntity<?> updateRecruiterStatus(@RequestParam("status") String status, @PathVariable Long id) {

        try {
            recruiterService.updateRecruiterStatus(id, status);
            return ResponseEntity.ok("Cập nhật trạng thái thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi cập nhật trạng thái");
        }
    }

    @GetMapping("/search")
    @ResponseBody
    public CommonResponse<?> searchRecruitersByName(RecruiterSearchRequest request) {
        return recruiterService.searchRecruiter(request );
    }

}
