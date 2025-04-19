package com.app.TodoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
