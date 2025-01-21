package com.example.spring_project2.controller;

import com.example.spring_project2.dto.TaskDto;
import com.example.spring_project2.entity.TaskStatus;
import com.example.spring_project2.entity.Tasks;
import com.example.spring_project2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskDto request) {
        try {
            Tasks task = new Tasks();
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setDueDate(request.getDueDate());
            taskService.createTask(task, request.getStatusId());

            return ResponseEntity.ok("Task Created ");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Tasks> getAllTasks(){
        return taskService.getAllTasks();

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id){
        try{
            Tasks task = taskService.getTaskById(id);
            return ResponseEntity.ok(task);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody TaskDto request){
        try{
            Tasks existingTask = taskService.getTaskById(id);
            existingTask.setTitle(request.getTitle());
            existingTask.setDescription(request.getDescription());
            existingTask.setDueDate(request.getDueDate());
            taskService.updateTask(existingTask,request.getStatusId());

            return ResponseEntity.ok("Task Updated ");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable int id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");

    }
}
