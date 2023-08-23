package com.example.tim_kiem_viec_lam.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobSearchRequest extends BaseSearchRequest{

    @NotBlank(message = "Tiêu đề không được để trống")
    String title;

    @Min(value = 0, message = "Lương tối đa phải là số không âm")
    Integer salaryFrom;

    @Min(value = 0, message = "Lương tối đa phải là số không âm")
    Integer salaryTo;

    @NotBlank(message = "Kỹ năng không được để trống")
    String skill;

    @NotBlank(message = "Địa điểm không được để trống")
    String location;

    @NotBlank(message = "Tên không được để trống")
    String name;

    @FutureOrPresent(message = "Hạn nộp phải là một thời điểm trong tương lai hoặc hiện tại")
    LocalDate dueDateTime;
}
