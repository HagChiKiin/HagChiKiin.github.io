package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("select r from Candidate r where r.user.id = :userId")
    Optional<Candidate> findByUserId(Long userId);

}
