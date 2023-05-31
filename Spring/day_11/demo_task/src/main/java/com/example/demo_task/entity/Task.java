package com.example.demo_task.entity;

import com.example.demo_task.statics.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    int id;
    String name;
    String description;
    Status status;
    LocalDate createdDateTime;
    LocalDate expectedEndTime;
    Boolean overdue;

}
