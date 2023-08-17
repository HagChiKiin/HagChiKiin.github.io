package com.example.tim_kiem_viec_lam.controller;

import com.example.tim_kiem_viec_lam.entity.Candidate;
import com.example.tim_kiem_viec_lam.entity.RefreshToken;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.exception.AccountNotActiveException;
import com.example.tim_kiem_viec_lam.exception.RefreshTokenNotFoundException;
import com.example.tim_kiem_viec_lam.model.request.LoginRequest;
import com.example.tim_kiem_viec_lam.model.request.RefreshTokenRequest;
import com.example.tim_kiem_viec_lam.model.request.RegistrationRequest;
import com.example.tim_kiem_viec_lam.model.response.JwtResponse;
import com.example.tim_kiem_viec_lam.repository.RefreshTokenRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.security.JwtUtils;
import com.example.tim_kiem_viec_lam.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authentication")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    ObjectMapper objectMapper;

    JwtUtils jwtUtils;

    UserService userService;

    UserRepository userRepository;

    RefreshTokenRepository refreshTokenRepository;

    AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public JwtResponse  authenticateUser(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        User user = userRepository.findById(userDetails.getId()).get();

        if (!user.isActivated()) {
            throw new AccountNotActiveException("Account not activated");
        }

        String refreshToken = UUID.randomUUID().toString();
        RefreshToken refreshTokenEntity = RefreshToken.builder()
                .refreshToken(refreshToken)
                .user(userRepository.findById(userDetails.getId()).get())
                .build();
        refreshTokenRepository.save(refreshTokenEntity);

        JwtResponse jwtResponse = JwtResponse.builder()
                .jwt(jwt)
                .refreshToken(refreshToken)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .roles(roles)
                .avatar("https://i.pravatar.cc/500?img=7")
                .build();
        Cookie jwtCookie = new Cookie("jwtToken", jwtResponse.getJwt());
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);
        return jwtResponse;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> new ResponseEntity<>("Email is existed", HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    userService.registerUser(request);
                    return new ResponseEntity<>(null, HttpStatus.CREATED);
                });
    }

    @PostMapping(value = "/recruiter-signup")
    public ResponseEntity<?> registerRecruiter(@RequestParam("recruiter") String recruiterStr,
                                               @RequestParam("avatar") MultipartFile avatar) {
        RegistrationRequest request;
        try {
            request = objectMapper.readValue(recruiterStr, RegistrationRequest.class);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Recruiter request data invalid", HttpStatus.BAD_REQUEST);
        }
        RegistrationRequest finalRequest = request;
        return userRepository.findByEmail(request.getEmail())
                .map(user -> new ResponseEntity<>("Email is existed", HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    try {
                        userService.registerRecruiter(finalRequest, avatar);
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                    return new ResponseEntity<>(null, HttpStatus.CREATED);
                });
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody @Valid RefreshTokenRequest request, HttpServletResponse response) {
        try {
            return ResponseEntity.ok(userService.refreshToken(request, response));
        } catch (RefreshTokenNotFoundException | UsernameNotFoundException ex) {
            return new ResponseEntity<>("Thông tin refreshToken không chính xác", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie jwtCookie = new Cookie("jwtToken", null);
        jwtCookie.setMaxAge(0);
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);

        userService.logout();
        return ResponseEntity.ok(null);
    }


}


