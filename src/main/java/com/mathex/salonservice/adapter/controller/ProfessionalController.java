package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.usecase.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping
    public List<Professional> getAllProfessionals() {
        return professionalService.getAllProfessionals();
    }

    @PostMapping
    public Professional createProfessional(@RequestBody Professional professional) {
        return professionalService.saveProfessional(professional);
    }

    @GetMapping("/searchBySpecialty")
    public List<Professional> getProfessionalsBySpecialty(@RequestParam String specialty) {
        return professionalService.findBySpecialty(specialty);
    }

    @GetMapping("/searchByAvailableHours")
    public List<Professional> getProfessionalsByAvailableHours(@RequestParam String availableHours) {
        return professionalService.findByAvailableHours(availableHours);
    }

    @PutMapping("/{id}")
    public Professional updateProfessional(@PathVariable Long id, @RequestBody Professional professional) {
        return professionalService.updateProfessional(id, professional);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessional(@PathVariable Long id) {
        professionalService.deleteProfessional(id);
    }
}
