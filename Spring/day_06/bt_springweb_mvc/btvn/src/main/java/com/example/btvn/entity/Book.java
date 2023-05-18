package com.example.btvn.entity;

import com.example.btvn.statics.Specialization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    int id;
    String name;
    String author;
    Specialization specialization;
    int publishedYear;

    private static int AUTO_ID =10000;

    public Book() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }



}
