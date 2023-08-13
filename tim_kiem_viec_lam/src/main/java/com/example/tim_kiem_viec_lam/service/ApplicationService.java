package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationService {

    ApplicationRepository applicationRepository;

}
