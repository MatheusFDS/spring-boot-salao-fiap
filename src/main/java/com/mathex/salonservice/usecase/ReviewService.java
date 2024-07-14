package com.mathex.salonservice.usecase;

import com.mathex.salonservice.domain.model.Review;
import com.mathex.salonservice.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByEstablishmentId(Long establishmentId) {
        return reviewRepository.findByEstablishmentId(establishmentId);
    }

    public List<Review> getReviewsByProfessionalId(Long professionalId) {
        return reviewRepository.findByProfessionalId(professionalId);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setClientId(updatedReview.getClientId());
                    review.setEstablishmentId(updatedReview.getEstablishmentId());
                    review.setProfessionalId(updatedReview.getProfessionalId());
                    review.setRating(updatedReview.getRating());
                    review.setComment(updatedReview.getComment());
                    return reviewRepository.save(review);
                })
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
