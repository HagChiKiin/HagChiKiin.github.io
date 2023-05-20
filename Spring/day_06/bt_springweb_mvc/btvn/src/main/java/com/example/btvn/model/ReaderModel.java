package com.example.btvn.model;

import com.example.btvn.statics.ReaderType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderModel {
    int id;
    @Size(max = 100 , message = "Name reader cannot over 100 characters")
    @NotBlank(message = "Name reader cannot be blank")
    String name;
    @Size(max = 100 , message = "Address reader cannot over 100 characters")
    @NotBlank(message = "Address reader cannot be blank")
    String address;
    @NotBlank(message = "Reader phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number character")
    String phone;
    ReaderType readerType;

    private static int AUTO_ID =10000;

    public ReaderModel() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

}
