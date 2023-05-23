package com.example.bt_driver.entity;

import com.example.bt_driver.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Driver extends Person{
    int id;
    Level level;


}
