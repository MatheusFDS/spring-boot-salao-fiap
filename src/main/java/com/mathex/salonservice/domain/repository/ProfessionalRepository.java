package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.Professional;
import java.util.List;

public interface ProfessionalRepository {
    List<Professional> findAll();
    Professional save(Professional professional);
}
