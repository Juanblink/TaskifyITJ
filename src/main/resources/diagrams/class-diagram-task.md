classDiagram
class Task {
+int id
+string title
+string description
+string status
+createTask()
+updateTask()
+deleteTask()
}
class User {
+int id
+string name
+createTask()
+viewTasks()
}
Task --> User : "Assigned To"