package com.example.bt_driver.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Busline {
    int id;

    String distance;
    int stopover;

}
