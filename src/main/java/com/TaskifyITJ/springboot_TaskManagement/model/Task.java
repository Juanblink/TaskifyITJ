package com.TaskifyITJ.springboot_TaskManagement.model;

public class Task {

    private int ID;
    private String Title;
    private String Description;
    private int Status;

    public Task(int ID, String title, String description, int status) {
        this.ID = ID;
        Title = title;
        Description = description;
        Status = status;
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
