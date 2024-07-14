package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
    List<Establishment> findByNameContainingIgnoreCaseOrServicesContainingIgnoreCase(String name, String services);

    List<Establishment> findByLocation(String location);
}
