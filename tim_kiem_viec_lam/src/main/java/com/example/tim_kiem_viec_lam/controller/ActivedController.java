package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.exception.ActivatedAccountException;
import com.example.tim_kiem_viec_lam.exception.OtpExpiredException;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActivedController {

    UserService userService;

    @GetMapping("/api/v1/users/{id}/activations")
    public  String  activeAccount(@PathVariable("id") Long id){
        try {
            userService.activeAccount(id);
            return "user/active-account";
        } catch (ActivatedAccountException e) {
            return "user/error";
        }
    }

    @GetMapping("/check-otp-reset")
    public String getResetPasswordPage(@RequestParam("otpCode") String otpCode) {
        try {
            userService.checkOtp(otpCode);
            return "user/reset-password";
        } catch (OtpExpiredException e) {
            return "user/login";
        }
    }
}
