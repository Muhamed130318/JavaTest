package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    public TasksService tasksService;

    public TasksController(TasksService tasksService){
        this.tasksService = tasksService;
    }

    @PostMapping
    public void addTask(@RequestBody TaskRequest taskRequest){
        tasksService.addTask(taskRequest);
    }

    @PutMapping("/test")
    public void markCompleted(@RequestBody TaskRequest taskRequest){
        System.out.println("Controller received request:");
        tasksService.markCompleted(taskRequest);
    }

    @DeleteMapping
    public void deleteTask(@RequestBody TaskRequest taskRequest){
        System.out.println("Controller received request:");
        tasksService.deleteTask(taskRequest);
    }
}
