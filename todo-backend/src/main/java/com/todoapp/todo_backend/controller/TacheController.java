package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.dto.TacheDTO;
import com.todoapp.todo_backend.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
@RequiredArgsConstructor
public class TacheController {

    private final TacheService tacheService;

    // GET - Lister toutes les tâches
    @GetMapping
    public ResponseEntity<List<TacheDTO>> getAllTaches() {
        return ResponseEntity.ok(tacheService.getAllTaches());
    }

    // POST - Ajouter une tâche
    @PostMapping
    public ResponseEntity<TacheDTO> createTache(@RequestBody TacheDTO dto) {
        return ResponseEntity.ok(tacheService.createTache(dto));
    }

    // PUT - Modifier une tâche
    @PutMapping("/{id}")
    public ResponseEntity<TacheDTO> updateTache(@PathVariable Long id, @RequestBody TacheDTO dto) {
        return ResponseEntity.ok(tacheService.updateTache(id, dto));
    }

    // DELETE - Supprimer une tâche
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH - Marquer une tâche comme terminée
    @PatchMapping("/{id}/terminer")
    public ResponseEntity<TacheDTO> marquerTerminee(@PathVariable Long id) {
        return ResponseEntity.ok(tacheService.marquerTerminee(id));
    }
}