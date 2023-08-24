package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.model.request.RecruiterRequest;
import com.example.tim_kiem_viec_lam.model.request.RecruiterSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.RecruiterSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    @Query("select r from Recruiter r where r.user.id = :userId")
    Optional<Recruiter> findByUserId(Long userId);

    @Query(value = "SELECT r.id, r.name, COUNT(j.id) AS job_count " +
            "FROM recruiters r " +
            "LEFT JOIN jobs j ON r.id = j.recruiter_id " +
            "GROUP BY r.id, r.name " +
            "ORDER BY job_count DESC " +
            "LIMIT 8", nativeQuery = true)
    List<Recruiter> findTopRecruitersWithMostJobs();

}
