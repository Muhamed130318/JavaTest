package com.example;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Optional;
import java.util.Collections;

@Service
public class ClientsService implements UserDetailsService{

    public ClientsRepository clientsRepository;
    private LogRepo logRepo;

    public ClientsService(ClientsRepository clientsRepository, LogRepo logRepo) {
        this.clientsRepository = clientsRepository;
        this.logRepo = logRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clients client = clientsRepository.findByName(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(client.getName(), client.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(client.getRole())));
    }

    public void addClient(Clients name){
        clientsRepository.save(name);
        logRepo.save(new Logs("Client " + name.getName() + " added."));
    }

    public Optional<Clients> getUserById(Integer id){
        logRepo.save(new Logs("Client with id " + id + " requested."));
        return Optional.ofNullable(clientsRepository.findById(id).orElse(null));
    }

    public Optional<Clients> getClientByName(String name){
        return Optional.ofNullable(clientsRepository.findByName(name));
    }

    public String deleteClient(String name){
        Clients client = clientsRepository.findByName(name);
        if (client != null) {
            clientsRepository.delete(client);
            logRepo.save(new Logs("Client " + name + " deleted."));
            return "Client deleted";
        }else {
            logRepo.save(new Logs("Attempted to delete " + name + " but client not found."));
            return "Client not found";
        }
    }
}
