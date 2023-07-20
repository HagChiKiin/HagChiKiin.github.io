package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.exception.ActivatedAccountException;
import com.example.tim_kiem_viec_lam.exception.ExistedUserException;
import com.example.tim_kiem_viec_lam.model.request.CreateUserRequest;
import com.example.tim_kiem_viec_lam.model.request.ExistedEmailRequest;
import com.example.tim_kiem_viec_lam.model.request.ReActivationAccountRequest;
import com.example.tim_kiem_viec_lam.model.request.ResetPasswordRequest;
import com.example.tim_kiem_viec_lam.model.response.UserResponse;
import com.example.tim_kiem_viec_lam.service.OtpService;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    OtpService otpService;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getDetail(@PathVariable Long id) throws ClassNotFoundException {
        return userService.getDetail(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateUserRequest request) {
        try {
            userService.createUser(request);
            return ResponseEntity.ok(null);
        } catch (ExistedUserException ex) {
            return new ResponseEntity<>("username đã tồn tại", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/email-check")
    public ResponseEntity<Boolean> existByEmail(@RequestBody ExistedEmailRequest existedEmailRequest){
        return ResponseEntity.ok(userService.existUserByEmail(existedEmailRequest.getEmail()));
    }

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        userService.sendOtp(email);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request){
        userService.resetPassword(request);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/active-account/{email}")
    public ModelAndView activeAccount(@PathVariable("email") String email) throws ActivatedAccountException {
        try {
            userService.activeAccount(email);
            return new ModelAndView("notification/activation.html");
        } catch (ActivatedAccountException e) {
            return new ModelAndView("notification/error.html");
        }
    }

    @PostMapping("/resend-activation-email/")
    public ResponseEntity<?> resentActivationEmail(@RequestBody ReActivationAccountRequest request, Long id){
        userService.resentActivationEmail(request.getEmail(), id);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
