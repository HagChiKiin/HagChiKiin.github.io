package com.example.demo_task.service;

import com.example.demo_task.model.response.TaskStatusResponse;
import com.example.demo_task.statics.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    public List<TaskStatusResponse> getStatus(){
        List<TaskStatusResponse> dto = new ArrayList<>();
        dto.add(new TaskStatusResponse(TaskStatus.TODO.toString(), TaskStatus.TODO.name));
        dto.add(new TaskStatusResponse(TaskStatus.IN_PROGRESS.toString(), TaskStatus.IN_PROGRESS.name));
        dto.add(new TaskStatusResponse(TaskStatus.REVIEWING.toString(), TaskStatus.REVIEWING.name));
        dto.add(new TaskStatusResponse(TaskStatus.COMPLETED.toString(), TaskStatus.COMPLETED.name));
        return dto;

    }

}
