package com.taskifyitj.springboot.taskmanagement.services;

import com.taskifyitj.springboot.taskmanagement.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository; // Mock for the repository

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testFindAllTasks() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(
                new Task(1, "Task 1", "Description 1", 1),
                new Task(2, "Task 2", "Description 2", 2)
        ));

        List<Task> tasks = taskService.findAllTasks();

        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void testFindTaskById() {
        Task task = new Task(1, "Task 1", "Description 1", 1);
        when(taskRepository.findById(1)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.findTaskById(1);

        assertTrue(result.isPresent());
        assertEquals("Task 1", result.get().getTitle());
        verify(taskRepository, times(1)).findById(1);
    }

    @Test
    void testCreateTask() {
        Task task = new Task(0, "New Task", "Description", 1);
        when(taskRepository.save(task)).thenReturn(new Task(1, "New Task", "Description", 1));

        Task result = taskService.createTask(task);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testDeleteTask() {
        when(taskRepository.existsById(1)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(1);

        boolean result = taskService.deleteTask(1);

        assertTrue(result);
        verify(taskRepository, times(1)).existsById(1);
        verify(taskRepository, times(1)).deleteById(1);
    }
}
