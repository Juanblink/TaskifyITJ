package com.taskifyitj.springboot.taskmanagement.services;

import com.taskifyitj.springboot.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // JpaRepository basic CRUD
}
