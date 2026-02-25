package com.todoapp.todo_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "taches")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private String statut; // "EN_COURS" ou "TERMINE"
}