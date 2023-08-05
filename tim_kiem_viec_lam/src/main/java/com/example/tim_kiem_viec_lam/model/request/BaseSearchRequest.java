package com.example.tim_kiem_viec_lam.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseSearchRequest {
    Integer pageIndex = 1;
    Integer pageSize = 3;
}
