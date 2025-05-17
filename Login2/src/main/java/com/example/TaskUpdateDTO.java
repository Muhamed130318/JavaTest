package com.example;

public class TaskUpdateDTO {
    String taskName;
    boolean completed = false;

    public TaskUpdateDTO(){}

    public String getTaskName(){
        return taskName;
    }

    public boolean isCompleted(){
        return completed;
    }

    public boolean markCompleted(){
        return this.completed = true;
    }

}
