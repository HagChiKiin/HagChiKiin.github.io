package com.example.driver_security.service;

import com.example.driver_security.entity.Driver;
import com.example.driver_security.entity.Role;
import com.example.driver_security.entity.User;
import com.example.driver_security.model.request.DriverCreateRequest;
import com.example.driver_security.model.request.DriverRequest;
import com.example.driver_security.model.request.DriverUpdateRequest;
import com.example.driver_security.model.response.DriverResponce;
import com.example.driver_security.model.response.UserResponse;
import com.example.driver_security.repository.DriverRepository;
import com.example.driver_security.repository.RoleRepository;
import com.example.driver_security.repository.UserRepository;
import com.example.driver_security.statics.Level;
import com.example.driver_security.statics.Roles;
import com.example.driver_security.validation.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverService {

    ObjectMapper objectMapper;

    PasswordEncoder passwordEncoder;

    DriverRepository driverRepository;

    RoleRepository roleRepository;
    List<Driver> drivers ;
    private static int AUTO_ID = 1;

    // Lấy danh sách tất cả lái xe
    public List<DriverResponce> getAll() {
        List<Driver> drivers = driverRepository.findAll();
        if (!CollectionUtils.isEmpty(drivers)) {
            return drivers.stream().map(u -> objectMapper.convertValue(u, DriverResponce.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public DriverResponce getDetail(long id) throws ClassNotFoundException {
        return driverRepository.findById( id).map(u -> objectMapper.convertValue(u, DriverResponce.class)).orElseThrow(ClassNotFoundException::new);
    }


    public void saveDriver(DriverCreateRequest driverCreateRequest) {
        Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        driver.setId(AUTO_ID);
        drivers.add(driver);
        AUTO_ID++;

    }
    public void delete(int id) {
        drivers.removeIf(a->a.getId() == id);
    }

    // Tìm lái xe theo ID
    public DriverUpdateRequest findById(Integer id) {
        Optional<Driver> driverOptional = drivers
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverOptional.isEmpty()) {
            throw new NotFoundException("Không tìm thấy lái xe mang mã " + id);
        }
        Driver driver = driverOptional.get();
        return objectMapper.convertValue(driver, DriverUpdateRequest.class);

    }

    public void updateDriver(DriverUpdateRequest driverUpdateRequest) {
        drivers.forEach(s->{
            if(s.getId() != driverUpdateRequest.getId()){
                return;
            }
            s.setId(driverUpdateRequest.getId());
            s.setName(driverUpdateRequest.getName());
            s.setAddress(driverUpdateRequest.getAddress());
            s.setPhone(driverUpdateRequest.getPhone());
            s.setLevel(Level.valueOf(driverUpdateRequest.getLevel()));

        });
    }

    // Tìm lái xe theo ID và trả về thông tin dưới dạng DriverResponse
    public DriverResponce findByIdVer2(Integer id) {
        Optional<Driver> driverOptional = drivers
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverOptional.isEmpty()) {
            throw new NotFoundException("Không tìm thấy lái xe mang mã " + id);
        }
        Driver driver = driverOptional.get();
        return objectMapper.convertValue(driver, DriverResponce.class);
    }

    public DriverResponce create(DriverRequest request) {
        Optional<Role> roleOptional = roleRepository.findByName(Roles.USER.name());

        Driver driver = new Driver();
        driver.setUsername(request.getUsername());
        driver.setPassword(passwordEncoder.encode(request.getPassword())); // Encrypt the password
        Set<Role> roles = new HashSet<>();
        roles.add(roleOptional.get());
        driver.setRoles(roles);
        driverRepository.save(driver);

        return objectMapper.convertValue(driver, DriverResponce.class);
    }
}
