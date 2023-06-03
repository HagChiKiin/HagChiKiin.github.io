package com.example.demo_task.service;

import com.example.demo_task.model.responce.TaskStatusResponse;
import com.example.demo_task.statics.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    public List<TaskStatusResponse> getStatus(){
        List<TaskStatusResponse> dto = new ArrayList<>();
        dto.add(new TaskStatusResponse(Status.TODO.toString(), Status.TODO.name));
        dto.add(new TaskStatusResponse(Status.IN_PROGRESS.toString(), Status.IN_PROGRESS.name));
        dto.add(new TaskStatusResponse(Status.REVIEWING.toString(), Status.REVIEWING.name));
        dto.add(new TaskStatusResponse(Status.DONE.toString(), Status.DONE.name));
        return dto;

    }

}
