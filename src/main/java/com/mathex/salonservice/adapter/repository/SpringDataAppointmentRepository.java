package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAppointmentRepository extends JpaRepository<Appointment, Long> {
}
