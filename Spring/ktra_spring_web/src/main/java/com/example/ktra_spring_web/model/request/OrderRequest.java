package com.example.ktra_spring_web.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Name cannot be blank!")
    String name;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be number characters")
    String phone;

    @NotBlank
    @Email
    String email;

    @NotNull
    @Min(value = 1, message = "min quantity must be = 1")
    Integer quantity;

}