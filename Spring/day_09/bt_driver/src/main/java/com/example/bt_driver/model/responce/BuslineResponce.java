package com.example.bt_driver.model.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuslineResponce {
    int id;
    String name;
    String distance;
    int stopover;

}
