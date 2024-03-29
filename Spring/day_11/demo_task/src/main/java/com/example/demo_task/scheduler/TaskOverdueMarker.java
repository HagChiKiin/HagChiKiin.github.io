package com.example.demo_task.scheduler;

import com.example.demo_task.entity.Task;
import com.example.demo_task.repository.TaskRepository;
import com.example.demo_task.statics.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskOverdueMarker {

    TaskRepository taskRepository;

    @Scheduled(fixedRate = 300000) //  5 phút
    public void taskOverdueMarker() {
        List<Task> tasks = taskRepository.getAll();
        if (!CollectionUtils.isEmpty(tasks)) {
            return;
        }

        val now = LocalDateTime.now();
        tasks.forEach(t -> t.setOverdue(t.getExpectedEndTime().isBefore(now) && !t.getStatus().equals(TaskStatus.COMPLETED)));
    }

}
