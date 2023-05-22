package com.example.student_02.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentModel {

    int id;

    @Size(max = 100 , message = "Name cannot over 100 characters")// dùng cho string, list,
    @NotBlank(message = "Student name cannot be blank") // ko được rỗng chỉ dùng cho string : sự kết hợp của notnull và not empty
    String name;

    @Size(max = 255 , message = "Address cannot over 255 characters")
    @NotBlank(message = "Student address cannot be blank") // ko được rỗng
    String address;

    @NotBlank(message = "Student phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number character") // thỏa mãn 1 quy luật gì đó:
    String phone;

    @NotNull(message = "Please enter birth date")  // notnull dùng cho đối tượng chung: string list  - bắt buộc phải truyền
    @Past(message = "Birth date should be less than current date!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    @Min(value = 0, message = "GPA cannot be less than 0")  // số
    @Max(value = 10, message = "GPA cannot be greater than 0") // hoặc dùng @Range(min=0, max =10)
           //email thì có @email
    float gpa;


}
