package com.example.ktra_spring_web.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    APPROVED("APPROVED","Approved"),
    REJECTED("REJECTED","Rejected"),
    PENDING("PENDING","Pending");

    public String code;
    public String name;
}
