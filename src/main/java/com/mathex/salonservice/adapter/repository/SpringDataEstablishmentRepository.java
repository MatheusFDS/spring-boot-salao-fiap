package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEstablishmentRepository extends JpaRepository<Establishment, Long> {
}
