package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.domain.repository.EstablishmentRepository;
import com.mathex.salonservice.domain.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Establishment> searchEstablishments(String keyword) {
        return establishmentRepository.findByNameContainingIgnoreCaseOrServicesContainingIgnoreCase(keyword, keyword);
    }

    public List<Professional> searchProfessionals(String keyword) {
        return professionalRepository.findByNameContainingIgnoreCaseOrSpecialtyContainingIgnoreCase(keyword, keyword);
    }
}
