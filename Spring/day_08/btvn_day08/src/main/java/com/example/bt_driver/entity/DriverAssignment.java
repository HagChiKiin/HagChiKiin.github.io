package com.example.bt_driver.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class DriverAssignment {
    int id;
    Driver driver;
    Busline busline;
    int quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
