package com.example.thymeleaf01.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Update {
    int id;
    String name;
    String address;
    String phone;
    LocalDate dob;
    String specialization;

}
