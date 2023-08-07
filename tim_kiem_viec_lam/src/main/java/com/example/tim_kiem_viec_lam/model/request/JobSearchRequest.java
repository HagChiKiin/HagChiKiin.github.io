package com.example.tim_kiem_viec_lam.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobSearchRequest extends BaseSearchRequest{

    String title;

    String salaryFrom;

    String salaryTo;

    String skill;

    String location;

    String name;

    LocalDate dueDateTime;
}
