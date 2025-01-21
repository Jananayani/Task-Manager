package com.example.spring_project2.dto;

import com.example.spring_project2.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private String title;
    private String description;
    private Integer statusId;
    private LocalDate dueDate;
}
