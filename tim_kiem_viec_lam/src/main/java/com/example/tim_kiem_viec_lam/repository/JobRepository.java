package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Otp;
import com.example.tim_kiem_viec_lam.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query(value = "SELECT * FROM jobs j WHERE SUBSTRING_INDEX(j.created_by, '.', 1) = :email", nativeQuery = true)
    List<Job> findByRecruiterEmail(@Param("email") String email);

    @Query("SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "AND j.dueDateTime >= CURRENT_DATE " +
            "ORDER BY j.salaryTo DESC")
    List<Job> findTop10ByHighestSalary();

    @Query(value = "SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "AND j.dueDateTime >= CURRENT_DATE " +
            "ORDER BY j.createdDateTime DESC")
    List<Job> findTop16ByNewestJobs();

    @Query(value = "SELECT j.*, COUNT(a.id) AS apply_count " +
            "FROM jobs j " +
            "JOIN recruiters r ON j.recruiter_id = r.id " +
            "INNER JOIN applications a ON j.id = a.job_id " +
            "WHERE j.job_status <> 'CLOSED' " +
            "AND r.status <> 'LOCKED' " +
            "AND j.due_DateTime >= CURRENT_DATE " +
            "GROUP BY j.id " +
            "ORDER BY apply_count DESC ", nativeQuery = true)
    List<Job> findTop16AttractiveJobs();

    @Query("SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "AND (j.skill LIKE CONCAT('%', :skill, '%') OR j.skill LIKE :skill) " +
            "AND j.id <> :jobId " +
            "AND j.dueDateTime >= CURRENT_DATE " +
            "ORDER BY RAND()")
    List<Job> findRandomJobsBySkillAndExcludeCurrentJob(@Param("skill") String skill, @Param("jobId") Long jobId);

    @Query("SELECT j FROM Job j JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' AND r.recruiterStatus <> 'LOCKED' AND j.dueDateTime >= CURRENT_DATE ORDER BY RAND()")
    List<Job> findAllExceptClosedAndLocked();

    @Query("SELECT j FROM Job j JOIN j.recruiter r " +
            "WHERE j.recruiter = :recruiter AND j.jobStatus <>'CLOSED' AND r.recruiterStatus <> 'LOCKED' AND j.id <> :id AND j.dueDateTime >= CURRENT_DATE")
    List<Job> findJobsByRecruiter(@Param("recruiter") Recruiter recruiter, @Param("id") Long id);

}
