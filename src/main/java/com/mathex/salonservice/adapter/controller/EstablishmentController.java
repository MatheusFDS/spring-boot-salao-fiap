package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.usecase.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Establishment createEstablishment(@RequestBody Establishment establishment) {
        return establishmentService.saveEstablishment(establishment);
    }

    @GetMapping("/searchByLocation")
    public List<Establishment> getEstablishmentsByLocation(@RequestParam String location) {
        return establishmentService.findByLocation(location);
    }

    @PutMapping("/{id}")
    public Establishment updateEstablishment(@PathVariable Long id, @RequestBody Establishment establishment) {
        return establishmentService.updateEstablishment(id, establishment);
    }

    @DeleteMapping("/{id}")
    public void deleteEstablishment(@PathVariable Long id) {
        establishmentService.deleteEstablishment(id);
    }
}
