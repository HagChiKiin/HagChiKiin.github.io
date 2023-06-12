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

    public void add(Task task) {
        task.setId(AUTO_ID);
        AUTO_ID++;
        tasks.add(task);
    }

    public Task getOne(Integer id) {
        for (Task t : tasks
        ) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void update(Task task) {
        tasks.forEach(s->{
            if(s.getId()!= task.getId()){
                return;
            }
            s.setName(task.getName());
            s.setDescription(task.getDescription());
            s.setStatus(task.getStatus());
            s.setExpectedEndTime(task.getExpectedEndTime());
        });
    }

    public void delete(Integer id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
