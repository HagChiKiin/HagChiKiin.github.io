package com.example.driver_security.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class PersonCreateRequest {
     @Size(max = 50, message = "Name cannot over 50 characters")
     @NotBlank(message = "Name cannot be blank!")
     String name;

     @Size(max = 255, message = "Address cannot over 50 characters")
     @NotBlank(message = "Address cannot be blank!")
     String address;

     @NotBlank(message = "Driver phone cannot be blank")
     @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
     String phone;
}
