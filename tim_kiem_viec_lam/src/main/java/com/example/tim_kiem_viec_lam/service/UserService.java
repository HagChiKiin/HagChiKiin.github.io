package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.*;
import com.example.tim_kiem_viec_lam.exception.ActivatedAccountException;
import com.example.tim_kiem_viec_lam.exception.ExistedUserException;
import com.example.tim_kiem_viec_lam.exception.OtpExpiredException;
import com.example.tim_kiem_viec_lam.exception.RefreshTokenNotFoundException;
import com.example.tim_kiem_viec_lam.model.request.CreateUserRequest;
import com.example.tim_kiem_viec_lam.model.request.RefreshTokenRequest;
import com.example.tim_kiem_viec_lam.model.request.RegistrationRequest;
import com.example.tim_kiem_viec_lam.model.request.ResetPasswordRequest;
import com.example.tim_kiem_viec_lam.model.response.JwtResponse;
import com.example.tim_kiem_viec_lam.model.response.UserResponse;
import com.example.tim_kiem_viec_lam.repository.*;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.security.JwtUtils;
import com.example.tim_kiem_viec_lam.security.SecurityUtils;
import com.example.tim_kiem_viec_lam.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    final PasswordEncoder passwordEncoder;

    final UserRepository userRepository;

    final RecruiterRepository recruiterRepository;

    final RoleRepository roleRepository;

    final ObjectMapper objectMapper;

    final OtpRepository otpRepository;

    final RefreshTokenRepository refreshTokenRepository;

    final EmailService emailService;

    FileRepository fileRepository;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    final JwtUtils jwtUtils;

    private static final String LOCAL_FOLDER = "/Users/Admin/Desktop";

    @Value("${application.user.avatar-folder}")
    private String userAvatarFolder;

    public String uploadLocalFile(MultipartFile file) throws IOException {
        if (ObjectUtils.isEmpty(file) || file.isEmpty()) {
            return null;
        }
        String filePath = LOCAL_FOLDER + File.separator + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       RecruiterRepository recruiterRepository, RoleRepository roleRepository, ObjectMapper objectMapper,
                       OtpRepository otpRepository, RefreshTokenRepository refreshTokenRepository,
                       EmailService emailService, FileRepository fileRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.recruiterRepository = recruiterRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.otpRepository = otpRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.emailService = emailService;
        this.fileRepository = fileRepository;
        this.jwtUtils = jwtUtils;
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        emailService.sendActivationEmail(user.getEmail(), user.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void registerRecruiter(RegistrationRequest registrationRequest, MultipartFile avatar) throws IOException {
        User user = saveUser(registrationRequest);
        String avatarPath = saveAvatar(avatar);
        saveRecruiter(user, registrationRequest, avatarPath);
        emailService.sendActivationEmail(user.getEmail(), user.getId());
    }

    private void saveRecruiter(User user, RegistrationRequest registrationRequest, String avatarPath) {
        Recruiter recruiter = Recruiter.builder()
                .user(user)
                .phone(registrationRequest.getPhone())
                .name(registrationRequest.getName())
                .contactInfo(registrationRequest.getContactInfo())
                .address(registrationRequest.getAddress())
                .introduce(registrationRequest.getIntroduce())
                .avatar(avatarPath)
                .build();
        recruiterRepository.save(recruiter);
    }

    private String saveAvatar(MultipartFile avatar) throws IOException {
        String fileName = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(avatar.getOriginalFilename());
        String filePath = userAvatarFolder + fileName + "." + extension;
        avatar.transferTo(new File(filePath));
        FileEntity fileEntity = FileEntity.builder()
                .name(fileName)
                .extensions(extension)
                .path(filePath)
                .size(avatar.getSize())
                .build();
        fileRepository.save(fileEntity);
        return filePath;
    }

    private User saveUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.RECRUITER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        return user;
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream().map(u -> objectMapper.convertValue(u, UserResponse.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserResponse getDetail(Long id) throws ClassNotFoundException {
        return userRepository.findById(id).map(u -> objectMapper.convertValue(u, UserResponse.class)).orElseThrow(ClassNotFoundException::new);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));


        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        refreshTokenRepository.logOut(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    public void createUser(CreateUserRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.USER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
    }

    public void activeAccount(Long id) throws ActivatedAccountException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setActivated(true);
            userRepository.save(user);
        }
    }

    public void sendOtp(String email) {
        emailService.sendOtp(email);
    }

    public Optional<User> findByEmailAndActivated(String email) {
        return userRepository.findByEmailAndActivated(email, true);
    }

    public void checkOtp(String otpCode) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(otpCode).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
    }

    public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(resetPasswordRequest.getOtpCode()).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
        User user = otp.getUser();
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);
    }


}
