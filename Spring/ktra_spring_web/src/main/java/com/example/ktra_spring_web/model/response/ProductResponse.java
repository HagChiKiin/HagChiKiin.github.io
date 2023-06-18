package com.example.ktra_spring_web.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Integer id;

    String name;

    Double price;

    String describe;

    String avatar;
}