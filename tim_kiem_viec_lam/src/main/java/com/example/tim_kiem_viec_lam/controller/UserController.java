package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.exception.ExistedUserException;
import com.example.tim_kiem_viec_lam.exception.OtpExpiredException;
import com.example.tim_kiem_viec_lam.model.request.CreateUserRequest;
import com.example.tim_kiem_viec_lam.model.request.EmailRequest;
import com.example.tim_kiem_viec_lam.model.request.ResetPasswordRequest;
import com.example.tim_kiem_viec_lam.model.response.UserResponse;
import com.example.tim_kiem_viec_lam.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

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
            return new ResponseEntity<>("Email đã tồn tại", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        userService.sendOtp(email);
    }

    @PostMapping("/otp-sending")
    public ResponseEntity<?> sendOtp(@RequestBody @Valid EmailRequest emailRequest) {
        return userService.findByEmailAndActivated(emailRequest.getEmail())
                .map(user -> {
                    userService.sendOtp(emailRequest.getEmail());
                    return new ResponseEntity<>(null, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Email không tồn tại trong hệ thống hoặc chưa kích hoạt", HttpStatus.NOT_FOUND));
    }


    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) throws OtpExpiredException {
        userService.resetPassword(resetPasswordRequest);
        return new ResponseEntity<>("Change password successful", HttpStatus.OK);
    }

}
