package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Candidate;
import com.example.tim_kiem_viec_lam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByUserId(Long userId);

    @Query("SELECT c FROM Candidate c WHERE c.user.id = :userId")
    Candidate findByUser_Id(Long userId);
}
