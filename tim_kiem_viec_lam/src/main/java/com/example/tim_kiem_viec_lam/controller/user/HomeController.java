package com.example.tim_kiem_viec_lam.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String getAll(){
        return "user/index";
    }

    @GetMapping("/user")
    public String getUser(){
        return "user/index-user";
    }

    @GetMapping("/jd-page")
    public String getJobDetail(){
        return "user/jd-page";
    }

    @GetMapping("/search")
    public String searchJob(){
        return "user/search";
    }

    @GetMapping("/register-employees")
    public String registerCandidate(){
        return "user/register-employees";
    }

    @GetMapping("/register-employers")
    public String registerRecruiter(){
        return "user/register-employers";
    }
}
