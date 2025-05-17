package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Logs, Integer> {
}
