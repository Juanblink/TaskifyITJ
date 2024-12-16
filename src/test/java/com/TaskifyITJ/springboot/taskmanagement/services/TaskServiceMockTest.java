package com.taskifyitj.springboot.taskmanagement.services;

import com.taskifyitj.springboot.taskmanagement.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This class tests the TaskService class using Mockito to mock the TaskRepository.
 * It ensures that the business logic in TaskService works correctly when interacting with the repository.
 */
class TaskServiceMockTest {

    // @Mock is used to create a mock object for the TaskRepository
    // This avoids using a real database and allows us to simulate repository behavior
    @Mock
    private TaskRepository taskRepository;

    // @InjectMocks automatically injects the mocked TaskRepository into TaskService
    // It initializes the TaskService class with the mock dependency
    @InjectMocks
    private TaskService taskService;

    /**
     * This method runs before each test case to initialize the mocks.
     * MockitoAnnotations.openMocks(this) initializes the @Mock and @InjectMocks annotations.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    /**
     * Test the getAllTasks() method of TaskService.
     * It checks if the method correctly retrieves all tasks from the repository.
     */
    @Test
    void testFindAllTasks() {
        // Arrange: Mock repository behavior
        when(taskRepository.findAll()).thenReturn(Arrays.asList(
                new Task(1, "Task 1", "Description 1", 1),
                new Task(2, "Task 2", "Description 2", 2)
        ));

        // Act: Call the method being tested
        List<Task> tasks = taskService.findAllTasks();

        // Assert: Verify the result
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    /**
     * Test the createTask() method of TaskService.
     * It checks if a task is correctly saved into the repository.
     */
    @Test
    void testCreateTask() {
        // Arrange: Prepare a Task object and define the behavior of the save() method
        Task task = new Task(1, "Task 1", "Description 1", 1);
        when(taskRepository.save(task)).thenReturn(task);

        // Act: Call the method we are testing
        Task result = taskService.createTask(task);

        // Assert: Check that the returned task matches the input task
        assertNotNull(result); // Ensure the result is not null
        assertEquals("Task 1", result.getTitle()); // Check the task title

        // Verify: Ensure the save() method of TaskRepository was called exactly once
        verify(taskRepository, times(1)).save(task);
    }

    /**
     * Test the deleteTask() method of TaskService.
     * It verifies that a task is deleted successfully if it exists in the repository.
     */
    @Test
    void testDeleteTask() {
        // Arrange: Define behavior for the existsById() and deleteById() methods
        when(taskRepository.existsById(1)).thenReturn(true); // Task exists
        doNothing().when(taskRepository).deleteById(1); // Simulate successful deletion

        // Act: Call the method we are testing
        boolean result = taskService.deleteTask(1);

        // Assert: Verify that the task deletion was successful
        assertTrue(result); // Check that the result is true

        // Verify: Ensure the methods were called as expected
        verify(taskRepository, times(1)).existsById(1); // Check existsById() was called
        verify(taskRepository, times(1)).deleteById(1); // Check deleteById() was called
    }
}
