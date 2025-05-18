package com.example;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TasksService {

    private final ClientsService clientsService;
    public TasksRepo tasksRepo;
    private LogRepo logRepo;

    public TasksService(TasksRepo tasksRepo, ClientsService clientsService, LogRepo logRepo){
        this.tasksRepo = tasksRepo;
        this.clientsService = clientsService;
        this.logRepo = logRepo;
    }

    public void addTask(TaskRequest taskRequest){
        Optional<Clients> client = clientsService.getUserById(taskRequest.getId());
        if (client.isEmpty()) {
            logRepo.save(new Logs("Attempted to add task to client with id " + taskRequest.getId() + " but client not found."));
            System.out.println("Attempted to add task to client with id " + taskRequest.getId() + " but client not found.");
            return;
        }
        Tasks tasks = new Tasks();
        tasks.setTaskName(taskRequest.getName());
        tasks.setClient(client);
        tasks.setCompleted(taskRequest.isCompleted());
        tasksRepo.save(tasks);
        logRepo.save(new Logs("Task " + taskRequest.getName() + " added."));
    }

    public void markCompleted(TaskRequest taskRequest){
        Tasks task = tasksRepo.findByTaskName(taskRequest.getName());
        System.out.println("Searching for task: " + taskRequest.getName());
        if (task != null) {
            task.setCompleted(taskRequest.isCompleted());
            tasksRepo.save(task);
            System.out.println("Task marked completed");
            logRepo.save(new Logs("Task " + taskRequest.getName() + " marked completed."));
        }else {
            System.out.println("Task not found");
            logRepo.save(new Logs("Attempted to mark completed " + taskRequest.getName() + " but task not found."));
        }
    }

    public void deleteTask(TaskRequest taskRequest){
        Tasks task = tasksRepo.findByTaskName(taskRequest.getName());
        if (task != null) {
            System.out.println("Deleting task: " + taskRequest.getName());
            tasksRepo.delete(task);
            System.out.println("Task deleted");
            logRepo.save(new Logs("Task " + taskRequest.getName() + " deleted."));
        }else {
            System.out.println("Task not found");
            logRepo.save(new Logs("Attempted to delete " + taskRequest.getName() + " but task not found."));
        }
    }
}
