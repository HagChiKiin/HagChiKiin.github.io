package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE ("Nam"),
    FEMALE ("Nữ");

    String name;

}
