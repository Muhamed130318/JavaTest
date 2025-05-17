package com.example;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TasksService {

    private final ClientsService clientsService;
    public TasksRepo tasksRepo;
   // public TaskUpdateDTO taskUpdateDTO;
    //public Tasks tasks;

    public TasksService(TasksRepo tasksRepo, ClientsService clientsService){
        this.tasksRepo = tasksRepo;
        this.clientsService = clientsService;
    }

    public void addTask(TaskRequest taskRequest){
        Optional<Clients> client = clientsService.getUserById(taskRequest.getId());

        Tasks tasks = new Tasks();
        tasks.setTaskName(taskRequest.getName());
        tasks.setClient(client);
        tasks.setCompleted(taskRequest.isCompleted());
        tasksRepo.save(tasks);
    }

    public void markCompleted(TaskRequest taskRequest){
        Tasks task = tasksRepo.findByTaskName(taskRequest.getName());
        System.out.println("Searching for task: " + taskRequest.getName());
        if (task != null) {
            task.setCompleted(taskRequest.isCompleted());
            tasksRepo.save(task);
            System.out.println("Task marked completed");
        }else {
            System.out.println("Task not found");
        }
    }

    public void deleteTask(TaskRequest taskRequest){
        Tasks task = tasksRepo.findByTaskName(taskRequest.getName());
        if (task != null) {
            System.out.println("Deleting task: " + taskRequest.getName());
            tasksRepo.delete(task);
            System.out.println("Task deleted");
        }else {
            System.out.println("Task not found");
        }
    }
}
