package com.example.tim_kiem_viec_lam.repository;

import com.example.tim_kiem_viec_lam.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    Optional<FileEntity> findByName(String name);

}
