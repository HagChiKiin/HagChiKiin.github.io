package com.example.btvn.entity;

import com.example.btvn.statics.ReaderType;
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
public class Reader {
    int id;
    String name;
    String address;
    String phone;
    ReaderType readerType;

    private static int AUTO_ID =10000;

    public Reader() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

}
