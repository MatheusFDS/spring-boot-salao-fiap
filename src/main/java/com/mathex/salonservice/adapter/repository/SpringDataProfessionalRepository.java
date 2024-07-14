package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProfessionalRepository extends JpaRepository<Professional, Long> {
}
