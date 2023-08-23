package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Đếm số lượng hồ sơ theo user_id đã nộp
    Long countByUserId(Long userId);

    List<Application> findByUserId(Long id);
}
