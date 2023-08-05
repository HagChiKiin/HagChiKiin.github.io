package com.example.tim_kiem_viec_lam.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResponse<T> {
    Integer pageNumber;
    T data;
}
