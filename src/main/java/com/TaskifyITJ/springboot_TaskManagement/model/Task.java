package com.TaskifyITJ.springboot_TaskManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks the class as a JPA entity
public class Task {

    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private int ID;

    private String Title;
    private String Description;
    private int Status;

    public Task() {} // Default constructor required by JPA

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
