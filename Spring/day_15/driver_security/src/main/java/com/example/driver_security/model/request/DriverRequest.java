package com.example.driver_security.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest {

    @NotBlank
    @Size(max = 100)
    String username;

    @NotBlank
    String password;

}
