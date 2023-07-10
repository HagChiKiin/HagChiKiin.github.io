package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationStatus {
    NOT_REVIEW,
    UNDER_REVIEW,
    APPROVED,
    REJECTED,
    INVITED_FOR_INTERVIEW,
    INTERVIEWED;
}
