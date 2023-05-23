package com.example.bt_driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignmentModel {
    int id;
    DriverModel driver;
    BuslineModel busline;
    int quantity;
}
