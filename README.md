# Taskify - Task Management System

## Overview

Taskify is a comprehensive task management system designed to help users manage their tasks efficiently. It provides a set of RESTful APIs for creating, updating, deleting, and retrieving tasks. Each task has essential attributes such as title, description, and status (Pending/Completed).

## Features

1. **REST APIs:** Perform CRUD operations on tasks.
2. **Database Integration:** Tasks are stored in a PostgreSQL or in-memory H2 database using JPA and Hibernate.
3. **Validation:** Ensures data integrity with request validation when creating or updating tasks.
4. **Unit Testing:** Includes unit tests using JUnit and Mockito to verify the service layer functionality.
5. **Clean Code Practices:** Focuses on writing clean and maintainable code by adhering to best practices and using tools like SonarQube.
6. **Documentation:** Provides detailed README and diagrams (UML class diagrams and sequence diagrams) to explain the system’s design and workflow.
7. **Presentation:** Includes a presentation to explain one milestone, discuss challenges faced, and showcase the working API.

## Usage

Users can interact with the provided APIs to manage their tasks, making task tracking and management efficient.

## Development Workflow

The project is broken down into milestones to be tackled over individual weekends, covering aspects from setup to testing, clean code practices, and documentation.

## Milestones Breakdown

### Milestone 1: Project Setup and Git Basics

- Set up a Spring Boot project with Maven.
- Initialize a Git repository and commit the basic folder structure.
- Create a `.gitignore` file.
- Write a simple `/health` endpoint to test the setup.

### Milestone 2: Core Task API

- Implement REST APIs for creating, updating, deleting, and retrieving tasks.
- Add attributes: `id`, `title`, `description`, `status` (Pending/Completed).
- Add basic request validation using `@Valid`.

### Milestone 3: Unit Testing Basics

- Write unit tests for the Task API service layer using JUnit and Mockito.

### Milestone 4: Database Integration

- Set up a PostgreSQL database or an in-memory H2 database.
- Implement persistence using JPA and Hibernate.
- Create schema for Task table and use it for CRUD operations.

### Milestone 5: Clean Code Practices

- Refactor code for readability, maintainability, and adherence to clean code principles.
- Use tools like SonarQube to identify and fix issues.

### Milestone 6: Diagrams

- Create a UML class diagram to represent entities like Task.
- Draw a sequence diagram for a task creation flow.

## Final Presentation

- Prepare a short presentation explaining one milestone, challenges faced, and solutions.
- Present diagrams and demonstrate the working API.

## How to Use

1. Clone the repository.
2. Follow the instructions in the README and milestones to set up the project.
3. Use Postman or cURL to interact with the APIs.
4. Implement each milestone as described.

## Live Presentation

- Date: Tuesday, December 17, 2024
- Time: 9:30 AM to 12:00 PM (PST)
