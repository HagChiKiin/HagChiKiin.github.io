package com.example.demo_task.service;

import com.example.demo_task.entity.Task;
import com.example.demo_task.model.request.TaskRequest;
import com.example.demo_task.model.response.TaskDetailResponse;
import com.example.demo_task.model.response.TaskResponse;
import com.example.demo_task.model.response.TaskStatusResponse;
import com.example.demo_task.repository.TaskRepository;
import com.example.demo_task.statics.TaskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskService {

    ObjectMapper objectMapper;

    TaskRepository taskRepository;

    public List<TaskResponse> getAll() {
        List<Task> tasks = taskRepository.getAll();
        List<TaskDetailResponse> tempData = tasks.stream().map(t -> objectMapper.convertValue(t, TaskDetailResponse.class)).collect(Collectors.toList());
        List<TaskStatus> taskStatuses = Arrays.asList(TaskStatus.values());

//        List<TaskResponse> result = new ArrayList<>();
//        for (int i = 0; i < taskStatuses.size(); i++) {
//            TaskStatus taskStatus = taskStatuses.get(i);
//            List<TaskDetailResponse> list = new ArrayList<>();
//
//            for (int j = 0; j < tempData.size(); j++) {
//                if(tempData.get(j).getStatus().equals(taskStatus)) {
//                    list.add(tempData.get(j));
//                }
//            }
//            TaskResponse taskResponse = new TaskResponse(taskStatus, list);
//            result.add(taskResponse);
//        }
//        return result;


        return taskStatuses.stream().map(status -> {
            List<TaskDetailResponse> taskDetailResponses = tempData.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
            return new TaskResponse(status, taskDetailResponses);
        }).collect(Collectors.toList());
    }

//    public List<TaskStatusResponse> getTaskStatus() {
//        return List.of(
//                TaskStatusResponse.builder().code(TaskStatus.TODO.getCode()).name(TaskStatus.TODO.getName()).build(),
//                TaskStatusResponse.builder().code(TaskStatus.IN_PROGRESS.getCode()).name(TaskStatus.IN_PROGRESS.getName()).build(),
//                TaskStatusResponse.builder().code(TaskStatus.REVIEWING.getCode()).name(TaskStatus.REVIEWING.getName()).build(),
//                TaskStatusResponse.builder().code(TaskStatus.COMPLETED.getCode()).name(TaskStatus.COMPLETED.getName()).build()
//        );
//    }

    public void saveTask(TaskRequest request) {
        Task task = objectMapper.convertValue(request, Task.class);

        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDateTime(now);
        task.setOverdue(task.getExpectedEndTime().isBefore(now));

        if (request.getId() != null) {
            taskRepository.update(task);
        } else {
            taskRepository.add(task);
        }
    }

    public TaskDetailResponse getDetail(Integer id) {
        Task task = taskRepository.getOne(id);
        return objectMapper.convertValue(task, TaskDetailResponse.class);
    }

    public void delete(Integer id) {
        taskRepository.delete(id);
    }

    public void updateStatus(Integer id, String statusId) {
        Task task = taskRepository.getOne(id);
        if (ObjectUtils.isEmpty(task)) {
            return;
        }
        task.setStatus(TaskStatus.valueOf(statusId));
        taskRepository.update(task);
    }
}
