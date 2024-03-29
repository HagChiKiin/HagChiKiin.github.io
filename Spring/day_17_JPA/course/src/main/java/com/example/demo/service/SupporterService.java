package com.example.demo.service;

import com.example.demo.model.Supporter;
import com.example.demo.model.Topic;
import com.example.demo.repository.SupporterRepository;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupporterService {

    private final SupporterRepository supporterRepository;

    public List<Supporter> getAllSupporter() {
        return supporterRepository.findAll();
    }

}
