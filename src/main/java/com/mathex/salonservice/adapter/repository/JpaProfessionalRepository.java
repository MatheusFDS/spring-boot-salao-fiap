package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.domain.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaProfessionalRepository implements ProfessionalRepository {

    @Autowired
    private SpringDataProfessionalRepository repository;

    @Override
    public List<Professional> findAll() {
        return repository.findAll();
    }

    @Override
    public Professional save(Professional professional) {
        return repository.save(professional);
    }
}
