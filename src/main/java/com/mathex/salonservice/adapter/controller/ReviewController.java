package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Review;
import com.mathex.salonservice.usecase.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/establishment/{establishmentId}")
    public List<Review> getReviewsByEstablishmentId(@PathVariable Long establishmentId) {
        return reviewService.getReviewsByEstablishmentId(establishmentId);
    }

    @GetMapping("/professional/{professionalId}")
    public List<Review> getReviewsByProfessionalId(@PathVariable Long professionalId) {
        return reviewService.getReviewsByProfessionalId(professionalId);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
