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

    public List<Professional> findBySpecialty(String specialty) {
        return professionalRepository.findBySpecialtyContaining(specialty);
    }

    public List<Professional> findByAvailableHours(String availableHours) {
        return professionalRepository.findByAvailableHoursContaining(availableHours);
    }

    public Professional updateProfessional(Long id, Professional updatedProfessional) {
        return professionalRepository.findById(id)
                .map(professional -> {
                    professional.setName(updatedProfessional.getName());
                    professional.setSpecialty(updatedProfessional.getSpecialty());
                    professional.setAvailableHours(updatedProfessional.getAvailableHours());
                    professional.setRates(updatedProfessional.getRates());
                    return professionalRepository.save(professional);
                })
                .orElseThrow(() -> new IllegalArgumentException("Professional not found"));
    }

    public void deleteProfessional(Long id) {
        professionalRepository.deleteById(id);
    }
}
