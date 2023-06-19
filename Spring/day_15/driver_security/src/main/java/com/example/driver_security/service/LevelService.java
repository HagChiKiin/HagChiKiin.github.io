package com.example.driver_security.service;

import com.example.driver_security.model.response.LevelResponce;
import com.example.driver_security.statics.Level;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelService {
    public List<LevelResponce> getAll() {
        List<LevelResponce> dtos = new ArrayList<>();
        dtos.add(new LevelResponce(Level.A.toString(), Level.A.name));
        dtos.add(new LevelResponce(Level.B.toString(), Level.B.name));
        dtos.add(new LevelResponce(Level.C.toString(), Level.C.name));
        dtos.add(new LevelResponce(Level.D.toString(), Level.D.name));
        dtos.add(new LevelResponce(Level.E.toString(), Level.E.name));
        dtos.add(new LevelResponce(Level.F.toString(), Level.F.name));
        return dtos;
    }
}
