package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkType {
    FULL_TIME("Toàn thời gian"),
    PART_TIME("Bán thời gian");

    String name;
}
