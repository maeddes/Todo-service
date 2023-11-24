package com.littlemonkey.todoapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean isDone;

    private Instant creationDate;
    private Instant dueDate;

    public Todo(){}

    public Todo(Long id, String name, String description, boolean isDone, Instant creationDate, Instant dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public Todo(Long id, String name, String description, boolean isDone, Instant creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.creationDate = creationDate;
        this.dueDate = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }
}
