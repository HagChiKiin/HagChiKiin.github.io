package com.example.tim_kiem_viec_lam.repository.custom;

import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.JobResponse;
import com.example.tim_kiem_viec_lam.model.response.JobSearchResponse;
import com.example.tim_kiem_viec_lam.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.jdbc.core.BeanPropertyRowMapper.*;

@Repository
public class JobCustomRepository extends BaseRepository {
    public List<JobSearchResponse> searchJob(JobSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        sql.append("SELECT ");
        sql.append("    j.id, ");
        sql.append("    j.skill, ");
        sql.append("    j.title, ");
        sql.append("    j.location, ");
        sql.append("    j.salary_to, ");
        sql.append("    j.salary_from, ");
        sql.append("    j.due_datetime, ");
        sql.append("    r.name as companyName, ");
        sql.append("    f.name as avatar ");
        sql.append("FROM ");
        sql.append("    jobs j ");
        sql.append("    LEFT JOIN recruiters r ON j.recruiter_id = r.id ");
        sql.append("    LEFT JOIN files f ON f.id = r.file_id ");
        sql.append("WHERE ");
        sql.append("    1 = 1 ");

        if (request.getTitle() != null && !request.getTitle().trim().equals("")) {
            sql.append("AND LOWER(j.title) LIKE :title ");
            parameters.put("title", "%" + request.getTitle().toLowerCase() + "%");
        }

        if (request.getLocation() != null && !request.getLocation().trim().equals("")) {
            sql.append("AND LOWER(j.location) LIKE :location ");
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
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameters, newInstance(JobSearchResponse.class));
    }
}
