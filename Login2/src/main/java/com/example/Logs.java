package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Logs {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Integer id;

    String log;
    LocalDateTime timeStamp;

    public Logs(){}

    public Logs(String log){
        this.log = log;
        this.timeStamp = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Logs logs = (Logs) o;
        return Objects.equals(id, logs.id) && Objects.equals(log, logs.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, log);
    }
}
