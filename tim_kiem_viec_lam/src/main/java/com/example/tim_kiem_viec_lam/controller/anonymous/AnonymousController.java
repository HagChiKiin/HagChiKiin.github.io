package com.example.tim_kiem_viec_lam.controller.anonymous;

import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.CommonResponse;
import com.example.tim_kiem_viec_lam.service.JobService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnonymousController {

    JobService jobService;

    @GetMapping("/search")
    @ResponseBody
    public CommonResponse<?> searchBook(JobSearchRequest request) {
        return jobService.searchJob(request);
    }
}
