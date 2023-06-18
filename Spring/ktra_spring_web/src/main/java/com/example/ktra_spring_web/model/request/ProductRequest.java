package com.example.ktra_spring_web.model.request;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    Integer id;

    @NotBlank
    @Size(max = 100)
    String name;

    @NotNull
    @Min(value = 0)
    Double price;

    @Length(max = 255)
    String description;

    @NotBlank
    String image;

}
