package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationStatus {
    NOT_REVIEW, // chưa xem
    REJECTED,  // từ chối
    INTERVIEW_SCHEDULED, // hẹn phỏng vấn
}
