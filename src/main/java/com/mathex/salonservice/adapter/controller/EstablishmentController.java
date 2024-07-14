package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.usecase.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establishments")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping
    public List<Establishment> getAllEstablishments() {
        return establishmentService.getAllEstablishments();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Establishment createEstablishment(@RequestBody Establishment establishment) {
        return establishmentService.saveEstablishment(establishment);
    }
}
