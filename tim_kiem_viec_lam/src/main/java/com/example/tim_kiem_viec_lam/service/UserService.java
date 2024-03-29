package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.*;
import com.example.tim_kiem_viec_lam.exception.*;
import com.example.tim_kiem_viec_lam.model.request.*;
import com.example.tim_kiem_viec_lam.model.response.JwtResponse;
import com.example.tim_kiem_viec_lam.model.response.UserResponse;
import com.example.tim_kiem_viec_lam.repository.*;
import com.example.tim_kiem_viec_lam.security.CustomUserDetails;
import com.example.tim_kiem_viec_lam.security.JwtUtils;
import com.example.tim_kiem_viec_lam.security.SecurityUtils;
import com.example.tim_kiem_viec_lam.statics.Gender;
import com.example.tim_kiem_viec_lam.statics.RecruiterStatus;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Set.of;

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

    final CandidateRepository candidateRepository;

    final FileRepository fileRepository;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    final JwtUtils jwtUtils;

    private static final String LOCAL_FOLDER = "D:/img/user-avatar/";

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
                       EmailService emailService, CandidateRepository candidateRepository, FileRepository fileRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.recruiterRepository = recruiterRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.otpRepository = otpRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.emailService = emailService;
        this.candidateRepository = candidateRepository;
        this.fileRepository = fileRepository;
        this.jwtUtils = jwtUtils;
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        User user = saveUserRole(registrationRequest);
        Candidate candidate = Candidate.builder()
                .user(user)
                .dob("")
                .gender(Gender.MALE)
                .address("")
                .experience("")
                .name("")
                .avatar("https://i.pravatar.cc/500?img=7")
                .build();
        candidate.setCreatedBy(user.getEmail());
        candidateRepository.save(candidate);
        emailService.sendActivationEmail(user.getEmail(), user.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void registerRecruiter(RegistrationRequest registrationRequest, MultipartFile avatar) throws IOException {
        User user = saveRecuiterRole(registrationRequest);
        FileEntity fileEntity = saveAvatar(avatar);
        String avatarPath = fileEntity.getPath();
        saveRecruiter(fileEntity, user, registrationRequest, avatarPath);
        emailService.sendActivationEmail(user.getEmail(), user.getId());
    }

    private void saveRecruiter(FileEntity fileEntity, User user, RegistrationRequest registrationRequest, String avatarPath) {
        Recruiter recruiter = Recruiter.builder()
                .user(user)
                .phone(registrationRequest.getPhone())
                .name(registrationRequest.getName())
                .contactInfo(registrationRequest.getContactInfo())
                .address(registrationRequest.getAddress())
                .introduce(registrationRequest.getIntroduce())
                .recruiterStatus(RecruiterStatus.ACTIVE)
                .avatar(avatarPath)
                .fileId(fileEntity)
                .build();
        recruiterRepository.save(recruiter);
    }

    private FileEntity saveAvatar(MultipartFile avatar) throws IOException {
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
        return fileEntity;
    }

    private User saveRecuiterRole(RegistrationRequest registrationRequest) {
        Role recruiterRole = roleRepository.findByName(Roles.RECRUITER)
                .orElseThrow(() -> new RuntimeException("Recruiter role not found!"));

        return getUser(registrationRequest, recruiterRole);
    }

    private User getUser(RegistrationRequest registrationRequest, Role recruiterRole) {
        Set<Role> roles = new HashSet<>();
        roles.add(recruiterRole);

        User user = User.builder()
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        return user;
    }

    private User saveUserRole(RegistrationRequest registrationRequest) {
        Role userRole = roleRepository.findByName(Roles.USER)
                .orElseThrow(() -> new RuntimeException("Recruiter role not found!"));

        return getUser(registrationRequest, userRole);
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

    public JwtResponse refreshToken(RefreshTokenRequest request, HttpServletResponse response) throws RefreshTokenNotFoundException {
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
        JwtResponse jwtResponse = JwtResponse.builder()
                .jwt(newToken)
                .build();

        Cookie jwtCookie = new Cookie("jwtToken", jwtResponse.getJwt());
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);
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


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found recruiter with id = " + id);
                });
    }

    public void changePassword(ChangePasswordRequest request) throws BadRequestException {
        Long currentUserLoginId = SecurityUtils.getCurrentUserLoginId().get();
        User user = userRepository.findById(currentUserLoginId).get();
        String newPassword = request.getNewPassword();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new BadRequestException();
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
