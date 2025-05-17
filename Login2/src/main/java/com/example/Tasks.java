package com.example;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    private String taskName;
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private Clients client;


    public Tasks(){}

    public Tasks(Integer id, String task, boolean completed){
        this.id = id;
        this.taskName = task;
        this.completed = completed;
    }

    public Integer getId(){
        return id;
    }

    public String getTaskName(){
        return taskName;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTaskName(String task){
        this.taskName = task;
    }

    public void setClient(Optional<Clients> client){
        this.client = client.orElse(null);
    }

    public boolean setCompleted(boolean completed){
        return this.completed = completed;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id) && Objects.equals(taskName, tasks.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName);
    }
}
