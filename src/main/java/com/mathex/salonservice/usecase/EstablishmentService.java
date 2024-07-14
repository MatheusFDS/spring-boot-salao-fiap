package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.domain.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public List<Establishment> getAllEstablishments() {
        return establishmentRepository.findAll();
    }

    public Establishment saveEstablishment(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }
}
