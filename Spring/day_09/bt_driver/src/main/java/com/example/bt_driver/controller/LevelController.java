package com.example.bt_driver.controller;

import com.example.bt_driver.model.responce.LevelResponce;
import com.example.bt_driver.service.LevelService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LevelController {
    LevelService levelService;

    @GetMapping
    public List<LevelResponce> getAll(){
        return levelService.getAll();
    }

}
