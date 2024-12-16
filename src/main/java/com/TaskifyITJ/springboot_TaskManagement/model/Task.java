package com.TaskifyITJ.springboot_TaskManagement.model;

import jakarta.persistence.*;

/**
 * package com.taskifyitj.springboot_TaskManagement.services; THIS WILL SOLVE THE PROBLEMS TO SONAR QUBE
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String Title;
    private String Description;
    private int Status;

    public Task() {} // Default constructor for JPA

    public Task(int ID, String title, String description, int status) {
        this.ID = ID;
        this.Title = title;
        this.Description = description;
        this.Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
