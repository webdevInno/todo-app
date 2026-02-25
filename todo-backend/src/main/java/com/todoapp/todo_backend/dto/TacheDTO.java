package com.todoapp.todo_backend.dto;

import lombok.Data;

@Data
public class TacheDTO {

    private Long id;
    private String titre;
    private String description;
    private String statut;
}