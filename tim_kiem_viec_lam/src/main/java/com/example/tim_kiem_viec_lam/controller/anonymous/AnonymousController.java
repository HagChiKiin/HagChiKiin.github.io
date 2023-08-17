package com.example.tim_kiem_viec_lam.controller.anonymous;

import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.service.JobService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnonymousController {

    JobService jobService;

//    @GetMapping("/search")
//    public String allBook(Model model, JobSearchRequest request) {
//        CommonResponse<?> commonResponse = jobService.searchJob(request);
//
//        model.addAttribute("pageBookInfo", commonResponse);
//        model.addAttribute("currentPage", request.getPageIndex());
//        model.addAttribute("pageSize", request.getPageSize());
//
//        return "admin/book-list";
//    }

}
