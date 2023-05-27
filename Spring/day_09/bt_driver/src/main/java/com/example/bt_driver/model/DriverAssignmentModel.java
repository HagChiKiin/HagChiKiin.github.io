package com.example.bt_driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignmentModel {
    int id;

    Integer driverId;
    String driverName;

    Integer buslineId;
    String buslineName;

    @NotNull(message = "Quantity of turn cannot be blank")
    @Range(min = 1, max = 15, message = "Quantity of turn must be greater than 0 and less than 16")
    int quantity;

    @NotNull(message = "Date cannot be blank")
    @PastOrPresent(message = "Date should be less than current date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
