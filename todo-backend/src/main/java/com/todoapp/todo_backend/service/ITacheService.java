package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.dto.TacheDTO;
import java.util.List;

public interface ITacheService {
    List<TacheDTO> getAllTaches();
    TacheDTO getTacheById(Long id);
    TacheDTO createTache(TacheDTO dto);
    TacheDTO updateTache(Long id, TacheDTO dto);
    void deleteTache(Long id);
    TacheDTO marquerTerminee(Long id);
}