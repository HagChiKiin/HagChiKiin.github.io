package com.example.tim_kiem_viec_lam.repository.custom;

import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.JobResponse;
import com.example.tim_kiem_viec_lam.model.response.JobSearchResponse;
import com.example.tim_kiem_viec_lam.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JobCustomRepository extends BaseRepository {
    public List<JobResponse> searchJob(JobSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        sql.append("SELECT ");
        sql.append("    j.id, ");
        sql.append("    j.skill, ");
        sql.append("    j.title, ");
        sql.append("    j.salary_to, ");
        sql.append("    j.salary_from ");
        sql.append("FROM ");
        sql.append("    jobs j ");
        sql.append("    LEFT JOIN recruiters r ON j.recruiter_id = r.id ");
        sql.append("WHERE ");
        sql.append("    1 = 1 ");

        if (request.getTitle() != null && !request.getTitle().trim().equals("")) {
            sql.append("AND LOWER(j.title) LIKE :title ");
            parameters.put("title", "%" + request.getTitle().toLowerCase() + "%");
        }

        if (request.getLocation() != null && !request.getLocation().trim().equals("")) {
            sql.append("AND LOWER(r.location) LIKE :location ");
            parameters.put("location", "%" + request.getLocation().toLowerCase() + "%");
        }

        if (request.getSkill() != null && !request.getSkill().trim().equals("")) {
            sql.append("AND LOWER(j.skill) LIKE :skill ");
            parameters.put("skill", "%" + request.getSkill().toLowerCase() + "%");
        }

        if (request.getName() != null && !request.getName().trim().equals("")) {
            sql.append("AND LOWER(r.name) LIKE :name ");
            parameters.put("name", "%" + request.getName().toLowerCase() + "%");
        }

        List<JobSearchResponse> jobSearchResponses = getNamedParameterJdbcTemplate()
                .query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(JobSearchResponse.class));

        List<JobResponse> jobResponseList = new ArrayList<>();
        jobSearchResponses.forEach(jobSearchResponse -> {
            JobResponse jobResponse = JobResponse.builder()
                    .id(jobSearchResponse.getId())
                    .skill(Arrays.asList(jobSearchResponse.getSkill().split(", ")))
                    .title(jobSearchResponse.getTitle())
                    .salaryTo(jobSearchResponse.getSalaryTo())
                    .salaryFrom(jobSearchResponse.getSalaryFrom())
                    .build();
            jobResponseList.add(jobResponse);
        });
        return jobResponseList;
    }
}
