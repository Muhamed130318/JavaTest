package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    public ClientsService clientsService;

    public ClientsController(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @PostMapping
    public void addClient(@RequestBody Clients client){
        clientsService.addClient(client);
    }

    @DeleteMapping("/{name}")
    public String deleteClient(@PathVariable String name){
        return clientsService.deleteClient(name);
    }

    @GetMapping("/{id}")
    public Optional<Clients> getClientById(@PathVariable Integer id){
        return clientsService.getUserById(id);
    }
}
