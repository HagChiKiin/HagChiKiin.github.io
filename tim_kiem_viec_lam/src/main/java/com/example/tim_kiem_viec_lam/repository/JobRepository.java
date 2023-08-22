package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.Job;
import com.example.tim_kiem_viec_lam.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query(value = "SELECT * FROM jobs j WHERE SUBSTRING_INDEX(j.created_by, '.', 1) = :email", nativeQuery = true)
    List<Job> findByRecruiterEmail(@Param("email") String email);
//

    @Query("SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "ORDER BY j.salaryTo DESC")
    List<Job> findTop10ByHighestSalary();


//    @Query(value = "SELECT * FROM jobs ORDER BY salary_to DESC LIMIT 10", nativeQuery = true)
//    List<Job> findTop10ByHighestSalary();

    @Query(value = "SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "ORDER BY j.createdDateTime DESC")
    List<Job> findTop16ByNewestJobs();
//
//    @Query(value = "SELECT * FROM jobs ORDER BY created_date_time DESC LIMIT 16", nativeQuery = true)
//    List<Job> findTop16ByNewestJobs();

    @Query(value = "SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "ORDER BY j.salaryFrom DESC")
    List<Job> findTop16ByHighestSalaryFrom();
//
//    @Query(value = "SELECT * FROM jobs ORDER BY salary_from DESC LIMIT 16", nativeQuery = true)
//    List<Job> findTop16ByHighestSalaryFrom();

    @Query("SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED' " +
            "AND (j.skill LIKE CONCAT('%', :skill, '%') OR j.skill LIKE :skill) " +
            "AND j.id <> :jobId " +
            "ORDER BY RAND()")
    List<Job> findRandomJobsBySkillAndExcludeCurrentJob(@Param("skill") String skill, @Param("jobId") Long jobId);

    @Query("SELECT j FROM Job j " +
            "JOIN j.recruiter r " +
            "WHERE j.jobStatus <> 'CLOSED' " +
            "AND r.recruiterStatus <> 'LOCKED'" +
            "ORDER BY RAND()")
    List<Job> findAllExceptClosedAndLocked();
//
//    @Query(value = "SELECT * FROM jobs WHERE skill LIKE %:skill% AND id <> :jobId ORDER BY RAND() LIMIT 3", nativeQuery = true)
//    List<Job> findRandomJobsBySkillAndExcludeCurrentJob(@Param("skill") String skill, @Param("jobId") Long jobId);

}
