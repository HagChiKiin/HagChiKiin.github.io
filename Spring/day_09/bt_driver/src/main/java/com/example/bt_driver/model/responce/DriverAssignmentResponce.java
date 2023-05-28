package com.example.bt_driver.model.responce;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.entity.Driver;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class DriverAssignmentResponce {
    int id;
    Driver driver;
    Busline busline;
    int quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate date;
}
