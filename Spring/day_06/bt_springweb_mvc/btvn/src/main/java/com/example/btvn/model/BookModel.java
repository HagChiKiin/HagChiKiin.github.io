package com.example.btvn.model;

import com.example.btvn.statics.Specialization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
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
    @Past(message = "Birth date should be less than current date!!")
    int publishedYear;

    private static int AUTO_ID =10000;

    public BookModel() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public void inputInfo() {
        System.out.println("Nhập vào tên đầu sách: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập vào tên tác giả: ");
        this.setAuthor(new Scanner(System.in).nextLine());

        System.out.println("Nhập vào năm xuất bản: ");
        this.setPublishedYear(new Scanner(System.in).nextInt());

        System.out.println("Nhập chuyên ngành: ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học - Nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");
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
            case 1 -> this.setSpecialization(Specialization.KHOA_HOC_TU_NHIEN);
            case 2 -> this.setSpecialization(Specialization.VAN_HOC_NGHE_THUAT);
            case 3 -> this.setSpecialization(Specialization.DIEN_TU_VIEN_THONG);
            case 4 -> this.setSpecialization(Specialization.CONG_NGHE_THONG_TIN);
        }

    }
}
