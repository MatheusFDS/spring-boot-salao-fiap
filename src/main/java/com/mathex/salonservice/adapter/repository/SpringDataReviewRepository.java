package com.mathex.salonservice.adapter.repository;

import com.mathex.salonservice.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByEstablishmentId(Long establishmentId);
    List<Review> findByProfessionalId(Long professionalId);
}
