package com.example.tim_kiem_viec_lam.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class RecruiterController {
    @GetMapping("/")
    public String getAll(){
        return "index";
    }

    @GetMapping("/jd-page")
    public String getAhill(){
        return "jd-page";
    }
}
