package com.example.spring_project2.service;

import com.example.spring_project2.dto.TaskDto;
import com.example.spring_project2.entity.TaskStatus;
import com.example.spring_project2.entity.Tasks;
import com.example.spring_project2.repository.TaskRepository;
import com.example.spring_project2.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    public Tasks createTask(Tasks task, Integer statusId) {
        System.out.println("statusId" + statusId);
        TaskStatus status = taskStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks getTaskById(Integer id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task id not found"));
    }

    public void updateTask(Tasks task, Integer statusId) {
        System.out.println("statusId" + statusId);
        TaskStatus status = taskStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        task.setStatus(status);
        taskRepository.save(task);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }
}
