package com.example;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientsService {

    public ClientsRepository clientsRepository;
    private LogRepo logRepo;

    public ClientsService(ClientsRepository clientsRepository, LogRepo logRepo) {
        this.clientsRepository = clientsRepository;
        this.logRepo = logRepo;
    }

    public void addClient(Clients name){
        clientsRepository.save(name);
        logRepo.save(new Logs("Client " + name.getName() + " added."));
    }

    public Optional<Clients> getUserById(Integer id){
        logRepo.save(new Logs("Client with id " + id + " requested."));
        return Optional.ofNullable(clientsRepository.findById(id).orElse(null));
    }

    public String deleteClient(String name){
        Clients client = clientsRepository.findByName(name);
        logRepo.save(new Logs("Client " + name + " deleted."));
        if (client != null) {
            clientsRepository.delete(client);
            return "Client deleted";
        }else {
            return "Client not found";
        }
    }
}
