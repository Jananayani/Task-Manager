package com.example.spring_project2.dto;

import com.example.spring_project2.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {

    @NotNull(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Status is required")
    private Integer statusId;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
}
