package com.example.driver_security.model.request;

import com.example.driver_security.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverCreateRequest extends PersonCreateRequest {
    @NotNull(message = "Level cannot be null")
    Level level;

}
