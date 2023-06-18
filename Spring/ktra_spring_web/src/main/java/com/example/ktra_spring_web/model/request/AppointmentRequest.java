package com.example.ktra_spring_web.model.request;

import com.example.ktra_spring_web.entity.User;
import com.example.ktra_spring_web.statics.Status;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequest {

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Name cannot be blank!")
    String name;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be number characters")
    String phone;

    @NotBlank
    @Email
    String email;

    @Length(max = 255)
    String message;

    Status status;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Appointment must be in the future")
    LocalDate appointmentAt;

}
