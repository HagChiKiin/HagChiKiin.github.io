package com.example.tim_kiem_viec_lam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TimKiemViecLamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimKiemViecLamApplication.class, args);
	}

}
