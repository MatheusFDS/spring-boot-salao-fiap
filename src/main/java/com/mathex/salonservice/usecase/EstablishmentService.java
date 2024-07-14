package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.domain.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public List<Establishment> getAllEstablishments() {
        return establishmentRepository.findAll();
    }

    public Establishment saveEstablishment(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

    public List<Establishment> findByLocation(String location) {
        return establishmentRepository.findByLocation(location);
    }

    public Establishment updateEstablishment(Long id, Establishment updatedEstablishment) {
        return establishmentRepository.findById(id)
                .map(establishment -> {
                    establishment.setName(updatedEstablishment.getName());
                    establishment.setAddress(updatedEstablishment.getAddress());
                    establishment.setServices(updatedEstablishment.getServices());
                    establishment.setProfessionals(updatedEstablishment.getProfessionals());
                    establishment.setOperatingHours(updatedEstablishment.getOperatingHours());
                    establishment.setPhotos(updatedEstablishment.getPhotos());
                    establishment.setLocation(updatedEstablishment.getLocation());
                    return establishmentRepository.save(establishment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Establishment not found"));
    }

    public void deleteEstablishment(Long id) {
        establishmentRepository.deleteById(id);
    }
}
