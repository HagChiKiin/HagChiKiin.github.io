package com.example.demo_task.model.request;

import com.example.demo_task.statics.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRequest {
    Integer id;

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = " name cannot be blank")
    String name;

    @Size(max = 255, message = " cannot over 255 characters")
    @NotBlank(message = " address cannot be blank")
    String description;

    @NotNull
    Status status;


    @NotNull(message = "Please enter ")
    @FutureOrPresent
    @Past(message = "should be less than current date!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate expectedEndTime;

}
