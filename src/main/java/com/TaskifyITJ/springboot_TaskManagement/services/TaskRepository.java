package com.TaskifyITJ.springboot_TaskManagement.services;

import com.TaskifyITJ.springboot_TaskManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // JpaRepository basic CRUD
}
