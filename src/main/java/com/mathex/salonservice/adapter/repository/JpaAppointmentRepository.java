package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Appointment;
import com.mathex.salonservice.domain.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaAppointmentRepository implements AppointmentRepository {

    @Autowired
    private SpringDataAppointmentRepository repository;

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }
}
