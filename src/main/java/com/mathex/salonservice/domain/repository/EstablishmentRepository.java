package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.Establishment;
import java.util.List;

public interface EstablishmentRepository {
    List<Establishment> findAll();
    Establishment save(Establishment establishment);
}
