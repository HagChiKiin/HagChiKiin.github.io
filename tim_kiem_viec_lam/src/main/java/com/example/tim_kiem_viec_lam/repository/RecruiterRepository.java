package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    @Query("select r from Recruiter r where r.user.id = :userId")
    Optional<Recruiter> findByUserId(Long userId);

}
