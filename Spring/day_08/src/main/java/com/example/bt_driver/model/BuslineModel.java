package com.example.bt_driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuslineModel {
    int id;

    @NotBlank(message = "distance cannot be blank!")
    @Min(value = 0, message = "distance cannot be less than 0")
    String distance;

    @NotBlank(message = "Name cannot be blank!")
    @Min(value = 0, message = "stopover cannot be less than 0")
    int stopover;

}
