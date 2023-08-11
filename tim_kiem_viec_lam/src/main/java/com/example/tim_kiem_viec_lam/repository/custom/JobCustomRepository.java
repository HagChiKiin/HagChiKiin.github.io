package com.example.tim_kiem_viec_lam.repository.custom;

import com.example.tim_kiem_viec_lam.model.request.JobSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.JobSearchResponse;
import com.example.tim_kiem_viec_lam.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

import static org.springframework.jdbc.core.BeanPropertyRowMapper.*;

@Repository
public class JobCustomRepository extends BaseRepository {
    public List<JobSearchResponse> searchJob(JobSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        sql.append("SELECT ");
        sql.append("j.id, ");
        sql.append("    j.skill, ");
        sql.append("    j.title, ");
        sql.append("    j.location, ");
        sql.append("    j.salary_from as salaryFrom, ");
        sql.append("    j.salary_to, ");
        sql.append("    j.due_datetime as dueDatetime, ");
        sql.append("    r.name as companyName, ");
        sql.append("    f.name as avatar ");
        sql.append("FROM jobs j ");
        sql.append("    LEFT JOIN recruiters r ON j.recruiter_id = r.id ");
        sql.append("    LEFT JOIN files f ON f.id = r.file_id ");
        sql.append("WHERE  1 = 1 ");

        if (request.getTitle() != null && !request.getTitle().trim().equals("")) {
            sql.append("AND LOWER(j.title) LIKE :title\n");
            parameters.put("title", "%" + request.getTitle().toLowerCase() + "%");
        }

        if (request.getLocation() != null && !request.getLocation().trim().equals("")) {
            sql.append("AND LOWER(j.location) LIKE :location\n");
            parameters.put("location", "%" + request.getLocation().toLowerCase() + "%");
        }

        if (request.getSkill() != null && !request.getSkill().trim().equals("")) {
            sql.append("AND LOWER(j.skill) LIKE :skill\n");
            parameters.put("skill", "%" + request.getSkill().toLowerCase() + "%");
        }

        if (request.getSalaryFrom() != null) {
            sql.append("AND j.salary_from >= :salaryFrom\n");
            parameters.put("salaryFrom",  request.getSalaryFrom());
        }

        if (request.getSalaryTo() != null ) {
            sql.append("AND j.salary_to <= :salaryTo\n");
            parameters.put("salaryTo", request.getSalaryTo());
        }

        if (request.getName() != null && !request.getName().trim().equals("")) {
            sql.append("AND LOWER(r.name) LIKE :name\n");
            parameters.put("name", "%" + request.getName().toLowerCase() + "%");
        }
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameters, newInstance(JobSearchResponse.class));
    }
}
