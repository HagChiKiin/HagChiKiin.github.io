package com.example.tim_kiem_viec_lam.config;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.entity.Role;
import com.example.tim_kiem_viec_lam.entity.User;
import com.example.tim_kiem_viec_lam.repository.RoleRepository;
import com.example.tim_kiem_viec_lam.repository.UserRepository;
import com.example.tim_kiem_viec_lam.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {

    UserRepository userRepository;

    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<Role> roleUserOptinal = roleRepository.findByName(Roles.USER);
        if(roleUserOptinal.isEmpty()){
            Role userRole = Role.builder().name(Roles.USER).build();
            roleRepository.save(userRole);

            Optional<User> candidate = userRepository.findByEmail("kien@gmail.com");
            if(candidate.isEmpty()){
                User user = new User();
                user.setEmail("kien@gmail.com");
                user.setActivated(true);
                user.setPassword(passwordEncoder.encode("kien123")); // Encrypt the password
                Set<Role> roles = new HashSet<>();
                roles.add(userRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        }
        Optional<Role> roleRecruiterOptinal = roleRepository.findByName(Roles.RECRUITER);
        if(roleRecruiterOptinal.isEmpty()){
            Role recruiterRole = Role.builder().name(Roles.RECRUITER).build();
            roleRepository.save(recruiterRole);

            Optional<User> recruiter = userRepository.findByEmail("fptsoftware@gmail.com");
            if(recruiter.isEmpty()){
                User user = new User();
                user.setEmail("fptsoftware@gmail.com");
                user.setActivated(true);
                user.setPassword(passwordEncoder.encode("fpt123")); // Encrypt the password
                Set<Role> roles = new HashSet<>();
                roles.add(recruiterRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        }

        Optional<Role> roleAdminOptinal = roleRepository.findByName(Roles.ADMIN);
        if(roleAdminOptinal.isEmpty()){
            Role adminRole = Role.builder().name(Roles.ADMIN).build();
            roleRepository.save(adminRole);

            Optional<User> admin = userRepository.findByEmail("admin@gmail.com");
            if(admin.isEmpty()){
                User user = new User();
                user.setEmail("admin@gmail.com");
                user.setActivated(true);
                user.setPassword(passwordEncoder.encode("admin123")); // Encrypt the password
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        }
    }
}
