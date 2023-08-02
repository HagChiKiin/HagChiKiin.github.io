package com.example.tim_kiem_viec_lam.service;

import com.example.tim_kiem_viec_lam.entity.FileEntity;
import com.example.tim_kiem_viec_lam.repository.FileRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileService {

    FileRepository fileRepository;

    public byte[] download(String fileName) {
        return fileRepository.findByName(fileName)
                .map(file -> {
                    byte[] data = null;
                    try (FileInputStream fl = new FileInputStream(file.getPath())) {
                        // Now creating byte array of same length as file
                        data = new byte[file.getSize().intValue()];

                        // Reading file content to byte array
                        // using standard read() method
                        fl.read(data);
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                    return data;
                })
                .orElse(null);
    }

    public FileEntity findByName(String name) {
        Optional<FileEntity> fileEntityOptional = fileRepository.findByName(name);
        if (fileEntityOptional.isEmpty()) {
            return null;
        }
        return fileEntityOptional.get();
    }

}
