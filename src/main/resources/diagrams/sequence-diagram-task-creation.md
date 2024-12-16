sequenceDiagram
participant User
participant TaskService
participant Database

    User->>TaskService: Request to create a task
    TaskService->>Database: Save task data
    Database-->>TaskService: Confirmation
    TaskService-->>User: Task created successfully