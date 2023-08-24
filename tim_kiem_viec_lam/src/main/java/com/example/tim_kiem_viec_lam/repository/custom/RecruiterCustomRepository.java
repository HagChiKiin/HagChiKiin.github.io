package com.example.tim_kiem_viec_lam.repository.custom;

import com.example.tim_kiem_viec_lam.model.request.RecruiterSearchRequest;
import com.example.tim_kiem_viec_lam.model.response.RecruiterSearchResponse;
import com.example.tim_kiem_viec_lam.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.jdbc.core.BeanPropertyRowMapper.newInstance;

@Repository
public class RecruiterCustomRepository extends BaseRepository {
    public List<RecruiterSearchResponse> searchRecruiter(RecruiterSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        sql.append("SELECT ");
        sql.append("r.id, ");
        sql.append("    r.name, ");
        sql.append("    r.address, ");
        sql.append("    r.introduce , ");
        sql.append("    r.contact_info AS contactInfo, ");
        sql.append("    r.avatar, ");
        sql.append("    r.phone, ");
        sql.append("    r.status AS recruiterStatus ");
        sql.append("FROM recruiters r ");
        sql.append("WHERE  1 = 1 ");


        if (request.getName() != null && !request.getName().trim().equals("")) {
            sql.append("AND LOWER(r.name) LIKE :name\n");
            parameters.put("name", "%" + request.getName().toLowerCase() + "%");
        }
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameters, newInstance(RecruiterSearchResponse.class));
    }
}
