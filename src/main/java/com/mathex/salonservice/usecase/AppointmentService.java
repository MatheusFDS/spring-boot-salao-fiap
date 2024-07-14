package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Appointment;
import com.mathex.salonservice.domain.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                    appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    appointment.setClientId(updatedAppointment.getClientId());
                    appointment.setProfessionalId(updatedAppointment.getProfessionalId());
                    appointment.setServices(updatedAppointment.getServices());
                    appointment.setStatus(updatedAppointment.getStatus());
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
