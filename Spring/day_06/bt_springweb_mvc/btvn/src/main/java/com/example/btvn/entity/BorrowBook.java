package com.example.btvn.entity;

import com.example.btvn.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowBook {
     int id;
     Reader reader;
     Book book;
     int quantity;
     Status status;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     LocalDate date;
}
