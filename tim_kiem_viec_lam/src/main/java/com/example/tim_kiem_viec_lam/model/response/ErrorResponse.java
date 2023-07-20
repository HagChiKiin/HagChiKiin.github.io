package com.example.tim_kiem_viec_lam.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String status;
    private String message;
    private Date timestamp;
}