package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.Appointment;
import java.util.List;

public interface AppointmentRepository {
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
}
