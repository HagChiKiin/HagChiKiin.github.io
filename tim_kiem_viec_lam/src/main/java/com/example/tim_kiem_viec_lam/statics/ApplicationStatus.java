package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationStatus {
    NOT_REVIEW("Chưa xem"), // chưa xem
    REJECTED ("Từ chối"),  // từ chối
    INTERVIEW_SCHEDULED ("Hẹn phỏng vấn"); // hẹn phỏng vấn

    String name;
}
