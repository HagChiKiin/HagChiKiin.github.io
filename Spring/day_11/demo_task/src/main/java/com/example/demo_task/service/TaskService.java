package com.example.demo_task.service;

import com.example.demo_task.entity.Task;
import com.example.demo_task.model.request.TaskRequest;
import com.example.demo_task.model.responce.TaskDetailResponse;
import com.example.demo_task.model.responce.TaskResponse;
import com.example.demo_task.repository.TaskRepository;
import com.example.demo_task.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskService {

    ObjectMapper objectMapper;

    TaskRepository taskRepository;

    public List<TaskResponse> getAll(){
        List<Task> tasks = taskRepository.getAll();
        List<TaskDetailResponse> taskDetailResponses = tasks.stream().map(s-> objectMapper.convertValue(s, TaskDetailResponse.class)).collect(Collectors.toList());
        List<Status> statuses = Arrays.asList(Status.values()); // sinh ra list khác để lọc ra các phần tử

//        List<TaskResponse> result = new ArrayList<>();
//        for (int i = 0; i < statuses.size(); i++) {
//            Status status = statuses.get(i);
//            List<TaskDetailResponse> list = new ArrayList<>();
//            for (int j = 0; j < taskDetailResponses.size(); j++) {
//                if(taskDetailResponses.get(i).getStatus().equals(status)){
//                    list.add(taskDetailResponses.get(i));
//                }
//            }
//            TaskResponse taskResponse = new TaskResponse(status,list);
//            result.add(taskResponse);
//        }
//        return  result;
        return statuses.stream().map(s->{
            List<TaskDetailResponse> collect = taskDetailResponses.stream().filter(t -> t.getStatus().equals(s)).collect(Collectors.toList());
            return  new TaskResponse(s, collect);
        }).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        taskRepository.delete(id);
    }

    public void saveTask(TaskRequest request) {
        Task task = objectMapper.convertValue(request, Task.class);

        LocalDate now = LocalDate.now();
        task.setCreatedDateTime(now);
        task.setOverdue(task.getExpectedEndTime().isBefore(now));

        if (request.getId() != null) {
            taskRepository.update(task);
        } else {
            taskRepository.saveTask(task);
        }
    }


    public TaskDetailResponse getDetail(Integer id) {
        Task task = taskRepository.getDetail(id);
        return objectMapper.convertValue(task,TaskDetailResponse.class);
    }
}
