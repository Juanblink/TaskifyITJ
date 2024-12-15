package com.TaskifyITJ.springboot_TaskManagement.services;

import com.TaskifyITJ.springboot_TaskManagement.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the TaskService class.
 * Uses Mockito to mock the TaskRepository dependency.
 */
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository; // Mocked repository

    private TaskService taskService; // Service being tested

    /**
     * Initializes the mocks and sets up the TaskService before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        taskService = new TaskService(taskRepository); // Inject mock into service
    }

    /**
     * Tests that getAllTasks() retrieves all tasks from the repository.
     */
    @Test
    void testGetAllTasks() {
        // Mock repository behavior
        when(taskRepository.findAll()).thenReturn(Arrays.asList(
                new Task(1, "Task 1", "Description 1", 1),
                new Task(2, "Task 2", "Description 2", 2)
        ));

        // Call the method under test
        List<Task> tasks = taskService.getAllTasks();

        // Verify the results
        assertEquals(2, tasks.size()); // Ensure 2 tasks are returned
        verify(taskRepository).findAll(); // Confirm findAll() was called
    }

    /**
     * Tests that createTask() saves a new task in the repository.
     */
    @Test
    void testCreateTask() {
        Task task = new Task(1, "New Task", "Description", 1);

        // Mock repository save behavior
        when(taskRepository.save(task)).thenReturn(task);

        // Call the method under test
        Task result = taskService.createTask(task);

        // Verify the results
        assertNotNull(result); // Task should not be null
        assertEquals("New Task", result.getTitle()); // Check title
        verify(taskRepository).save(task); // Confirm save() was called
    }

    /**
     * Tests that deleteTask() successfully deletes a task when it exists.
     */
    @Test
    void testDeleteTask() {
        // Mock repository behavior
        when(taskRepository.existsById(1)).thenReturn(true);

        // Call the method under test
        boolean result = taskService.deleteTask(1);

        // Verify the results
        assertTrue(result); // Deletion should succeed
        verify(taskRepository).existsById(1); // Check if existsById() was called
        verify(taskRepository).deleteById(1); // Confirm deleteById() was called
    }
}
