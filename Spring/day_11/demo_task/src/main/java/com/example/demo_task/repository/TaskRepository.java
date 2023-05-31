package com.example.demo_task.repository;

import com.example.demo_task.entity.Task;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRepository {

    static int AUTO_ID = 1;
    final List<Task> tasks = new ArrayList<>();

    public List<Task> getAll() {
        return tasks;
    }

}
