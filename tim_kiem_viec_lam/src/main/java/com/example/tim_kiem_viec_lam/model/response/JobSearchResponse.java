package com.example.tim_kiem_viec_lam.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobSearchResponse {

    Long id;

    String name;

    String title;

    String location;

    String salaryFrom;

    String salaryTo;

    String skill;

    LocalDate published;

}
