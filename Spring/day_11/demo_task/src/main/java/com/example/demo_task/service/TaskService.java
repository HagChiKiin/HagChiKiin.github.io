package com.example.demo_task.service;

import com.example.demo_task.entity.Task;
import com.example.demo_task.model.request.TaskRequest;
import com.example.demo_task.model.responce.TaskDetailResponse;
import com.example.demo_task.model.responce.TaskResponce;
import com.example.demo_task.repository.TaskRepository;
import com.example.demo_task.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskService {

    ObjectMapper objectMapper;

    TaskRepository taskRepository;

    public List<TaskResponce> getAll(){
        List<Task> tasks = taskRepository.getAll();
        List<TaskDetailResponse> taskDetailResponses = tasks.stream().map(s-> objectMapper.convertValue(s, TaskDetailResponse.class)).collect(Collectors.toList());
        List<Status> statuses = Arrays.asList(Status.values());

        List<TaskResponce> result = new ArrayList<>();
        for (int i = 0; i < statuses.size(); i++) {
            Status status = statuses.get(i);
            List<TaskDetailResponse> list = new ArrayList<>();
            for (int j = 0; j < taskDetailResponses.size(); j++) {
                if(taskDetailResponses.get(i).getStatus().equals(status)){
                    list.add(taskDetailResponses.get(i));
                }
            }
            TaskResponce taskResponce = new TaskResponce(status,list);
            result.add(taskResponce);
        }
        return  result;
//        status.stream().map(s->{
//            taskDetailResponses.stream().filter(t -> t.getStatus().equals(s)).collect(Collectors.toList());
//        })

    }

    public void saveTask(TaskRequest request) {
    }

    public void delete(Integer id) {
    }
}
