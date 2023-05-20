package com.example.btvn.model;

import com.example.btvn.statics.Specialization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookModel {
    int id;
    @Size(max = 100 , message = "Title cannot over 100 characters")// dùng cho string, list,
    @NotBlank(message = "Title cannot be blank")
    String name;
    @Size(max = 100 , message = "Author cannot over 100 characters")// dùng cho string, list,
    @NotBlank(message = "Author name cannot be blank")
    String author;

    Specialization specialization;
    @NotNull(message = "Please enter publishedYear")
    @Max(value = 2023 ,message = "Birth date should be less than current date!!")
    int publishedYear;

    private static int AUTO_ID =10000;

    public BookModel() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }




}
