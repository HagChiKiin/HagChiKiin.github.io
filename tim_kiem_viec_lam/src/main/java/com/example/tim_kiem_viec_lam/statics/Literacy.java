package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Literacy {
    UNIVERSITY, // Đại học
    COLLEGE, // Cao đẳng
    INTERMEDIATE, // Trung cấp
    NONE; // Không yêu cầu trình độ học vấn
}
