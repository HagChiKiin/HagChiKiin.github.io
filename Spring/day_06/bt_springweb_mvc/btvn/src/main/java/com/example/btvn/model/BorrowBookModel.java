package com.example.btvn.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowBookModel {
    ReaderModel readerModel;
    List<BorrowBookDetailsModel> borrowBookDetailModels;
}
