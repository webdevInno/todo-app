package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.dto.TacheDTO;
import com.todoapp.todo_backend.entity.Tache;
import com.todoapp.todo_backend.repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacheService {

    private final TacheRepository tacheRepository;

    // Lister toutes les tâches
    public List<TacheDTO> getAllTaches() {
        return tacheRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    // Récupérer une tâche par id
    public TacheDTO getTacheById(Long id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        return convertToDTO(tache);
    }

    // Ajouter une tâche
    public TacheDTO createTache(TacheDTO dto) {
        Tache tache = new Tache();
        tache.setTitre(dto.getTitre());
        tache.setDescription(dto.getDescription());
        tache.setStatut("EN_COURS");
        return convertToDTO(tacheRepository.save(tache));
    }

    // Modifier une tâche
    public TacheDTO updateTache(Long id, TacheDTO dto) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        tache.setTitre(dto.getTitre());
        tache.setDescription(dto.getDescription());
        tache.setStatut(dto.getStatut());
        return convertToDTO(tacheRepository.save(tache));
    }

    // Supprimer une tâche
    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }

    // Marquer une tâche comme terminée
    public TacheDTO marquerTerminee(Long id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        tache.setStatut("TERMINE");
        return convertToDTO(tacheRepository.save(tache));
    }

    // Convertir Tache en TacheDTO
    private TacheDTO convertToDTO(Tache tache) {
        TacheDTO dto = new TacheDTO();
        dto.setId(tache.getId());
        dto.setTitre(tache.getTitre());
        dto.setDescription(tache.getDescription());
        dto.setStatut(tache.getStatut());
        return dto;
    }
}