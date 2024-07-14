package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByNameContainingIgnoreCaseOrSpecialtyContainingIgnoreCase(String name, String specialty);

    List<Professional> findBySpecialtyContaining(String specialty);

    List<Professional> findByAvailableHoursContaining(String availableHours);
}
