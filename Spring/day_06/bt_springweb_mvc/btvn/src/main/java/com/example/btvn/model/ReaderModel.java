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

    public void inputInfo() {
        System.out.println("Nhập vào tên bạn đọc: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập vào địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());

        System.out.println("Nhập vào số điện thoại: ");
        this.setPhone(new Scanner(System.in).nextLine());

        System.out.println("Nhập loại bạn đọc: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        int choise;
        do {
            try {
                choise = new Scanner(System.in).nextInt();
                if (choise >= 1 && choise <= 4) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng chọn từ 1 đến 4");
            }
        } while (true);
        switch (choise) {
            case 1 -> this.setReaderType(ReaderType.SINH_VIEN);
            case 2 -> this.setReaderType(ReaderType.HOCVIEN_CAOHOC);
            case 3 -> this.setReaderType(ReaderType.GIANG_VIEN);
        }

    }
}
