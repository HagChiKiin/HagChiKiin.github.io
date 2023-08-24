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
public class RecruiterSearchRequest extends BaseSearchRequest{

    @NotBlank(message = "Địa điểm không được để trống")
    String address;

    @NotBlank(message = "Tên không được để trống")
    String name;

}
