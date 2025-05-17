package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    public Optional<Clients> findById(Integer id);
    public Clients findByName(String name);
}
