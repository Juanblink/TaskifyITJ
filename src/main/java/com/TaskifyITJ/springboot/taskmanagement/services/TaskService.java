package com.taskifyitj.springboot.taskmanagement.services;

import com.taskifyitj.springboot.taskmanagement.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection for TaskRepository
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Retrieve all tasks from the database.
     * @return List of tasks
     */
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Retrieve a single task by its ID.
     * @param id The task ID
     * @return Optional of Task
     */
    public Optional<Task> findTaskById(int id) {
        return taskRepository.findById(id);
    }

    /**
     * Save a new task in the database.
     * @param task Task to be created
     * @return The created task
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Update an existing task in the database.
     * @param id The ID of the task to update
     * @param updatedTask Task with updated fields
     * @return Updated task if found
     */
    public Optional<Task> updateTask(int id, Task updatedTask) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingTask);
        });
    }

    /**
     * Delete a task by its ID.
     * @param id The ID of the task to delete
     * @return true if deleted successfully, otherwise false
     */
    public boolean deleteTask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
