package com.example.demo_task.repository;

import com.example.demo_task.entity.Task;
import com.example.demo_task.model.request.TaskRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRepository {

    final List<Task> tasks = new ArrayList<>();
    static int AUTO_ID = 1;


    public List<Task> getAll() {
        return tasks;
    }

    public void saveTask(Task task) {
        task.setId(AUTO_ID);
        tasks.add(task);
        AUTO_ID++;

    }

    public Task getDetail(Integer id) {
        for (Task t : tasks
        ) {
            if (t.getId() == id) {
                return t;

            }
        }
        return null;
    }

    public void delete(Integer id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    public void update(Task task) {
        tasks.forEach(s->{
            if(s.getId()!= task.getId()){
                return;
            }
            s.setId(task.getId());
            s.setName(task.getName());
            s.setDescription(task.getDescription());
            s.setStatus(task.getStatus());
            s.setCreatedDateTime(task.getCreatedDateTime());
            s.setExpectedEndTime(task.getExpectedEndTime());
            s.setOverdue(task.getOverdue());
        });
    }

}