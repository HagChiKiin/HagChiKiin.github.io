package com.example.tim_kiem_viec_lam.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecruiterSearchResponse {
    Long id;

    String name;

    String address;

    String recruiterStatus;

    String phone;

    String contactInfo;

}
