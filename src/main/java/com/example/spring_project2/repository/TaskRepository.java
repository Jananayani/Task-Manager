package com.example.spring_project2.repository;

import com.example.spring_project2.dto.TaskDto;
import com.example.spring_project2.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {
}
