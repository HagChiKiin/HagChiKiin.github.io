package com.example.tim_kiem_viec_lam.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobStatus {
    OPEN,  // Đang mở tuyển dụng
    ONGOING_INTERVIEWS, // Đang tiến hành phỏng vấn
    HIRED, // Đã tuyển dụng thành công
    CLOSED, // Đã đóng tuyển dụng
    CANCELLED// Đã hủy tuyển dụng

}
