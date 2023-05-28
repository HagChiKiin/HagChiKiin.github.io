package com.example.bt_driver.model.request;

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
public class BuslineCreateRequest {
    int id;

    @NotBlank(message = "distance cannot be blank!")
    String name;

    @NotBlank(message = "distance cannot be blank!")

    String distance;

    @Min(value = 0, message = "stopover cannot be less than 0")
    int stopover;


}
