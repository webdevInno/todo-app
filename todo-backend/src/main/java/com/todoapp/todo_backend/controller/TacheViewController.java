package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.dto.TacheDTO;
import com.todoapp.todo_backend.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/taches")
@RequiredArgsConstructor
public class TacheViewController {

    private final TacheService tacheService;

    @GetMapping
    public String index(Model model) {
        List<TacheDTO> taches = tacheService.getAllTaches();
        long enCours = taches.stream()
                .filter(t -> "EN_COURS".equals(t.getStatut())).count();
        long termine = taches.stream()
                .filter(t -> "TERMINE".equals(t.getStatut())).count();

        model.addAttribute("taches", taches);
        model.addAttribute("nouvelleTache", new TacheDTO());
        model.addAttribute("enCours", enCours);
        model.addAttribute("termine", termine);
        return "taches";
    }

    @PostMapping("/ajouter")
    public String ajouter(@ModelAttribute TacheDTO dto) {
        tacheService.createTache(dto);
        return "redirect:/taches";
    }

    @GetMapping("/modifier/{id}")
    public String modifierForm(@PathVariable Long id, Model model) {
        model.addAttribute("tache", tacheService.getTacheById(id));
        return "modifier";
    }

    @PostMapping("/modifier/{id}")
    public String modifier(@PathVariable Long id, @ModelAttribute TacheDTO dto) {
        tacheService.updateTache(id, dto);
        return "redirect:/taches";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        tacheService.deleteTache(id);
        return "redirect:/taches";
    }

    @GetMapping("/terminer/{id}")
    public String terminer(@PathVariable Long id) {
        tacheService.marquerTerminee(id);
        return "redirect:/taches";
    }
}