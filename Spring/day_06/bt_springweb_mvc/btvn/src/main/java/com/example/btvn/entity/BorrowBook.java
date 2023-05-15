package com.example.btvn.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowBook {
    Reader reader;
    List<BorrowBookDetails> borrowBookDetails;
}
