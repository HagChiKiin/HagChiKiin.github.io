package com.example.bt_driver.model.request;

import com.example.bt_driver.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverUpdateRequest extends PersonUpdateRequest {
    int id;
    @NotBlank(message = "Level cannot be null")
    String level;

}
