package com.example.bt_driver.model;

import com.example.bt_driver.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverModel extends PersonModel {
    int id;
    Level level;

}
