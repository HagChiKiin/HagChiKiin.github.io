package com.example.driver_security.repository;


import com.example.driver_security.entity.Driver;
import com.example.driver_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByUsername(String username);

}