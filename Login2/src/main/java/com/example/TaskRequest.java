package com.example;

public class TaskRequest {

    private String name;
    private Integer id;
    private boolean completed = false;

    public TaskRequest(){}

    public String getName() {
        return name;
    }

    public Integer getId(){
        return id;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
