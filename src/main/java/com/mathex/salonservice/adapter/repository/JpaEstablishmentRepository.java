package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.domain.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaEstablishmentRepository implements EstablishmentRepository {

    @Autowired
    private SpringDataEstablishmentRepository repository;

    @Override
    public List<Establishment> findAll() {
        return repository.findAll();
    }

    @Override
    public Establishment save(Establishment establishment) {
        return repository.save(establishment);
    }
}
