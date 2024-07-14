package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.usecase.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Professional createProfessional(@RequestBody Professional professional) {
        return professionalService.saveProfessional(professional);
    }
}
