package com.TaskifyITJ.springboot_TaskManagement.controllers;

import com.TaskifyITJ.springboot_TaskManagement.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    private List<Task> tasks = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // For unique task IDs

    public TaskRestController() {
        // Initialize with some sample tasks
        tasks.add(new Task(idCounter.getAndIncrement(), "Task 1", "Setup the project", 1));
        tasks.add(new Task(idCounter.getAndIncrement(), "Task 2", "Make the model", 1));
        tasks.add(new Task(idCounter.getAndIncrement(), "Task 3", "Make the controller", 2));
        tasks.add(new Task(idCounter.getAndIncrement(), "Task 4", "Run the project", 1));
    }


    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return tasks.stream()
                .filter(task -> task.getID() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setID(idCounter.getAndIncrement());
        tasks.add(task);
        return ResponseEntity.ok(task);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        return tasks.stream()
                .filter(task -> task.getID() == id)
                .findFirst()
                .map(existingTask -> {
                    existingTask.setTitle(updatedTask.getTitle());
                    existingTask.setDescription(updatedTask.getDescription());
                    existingTask.setStatus(updatedTask.getStatus());
                    return ResponseEntity.ok(existingTask);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        boolean removed = tasks.removeIf(task -> task.getID() == id);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
