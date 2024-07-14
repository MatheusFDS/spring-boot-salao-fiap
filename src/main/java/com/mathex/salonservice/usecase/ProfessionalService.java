package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.domain.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Professional> getAllProfessionals() {
        return professionalRepository.findAll();
    }

    public Professional saveProfessional(Professional professional) {
        return professionalRepository.save(professional);
    }
}
