package com.embarkx.firstjobapp.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long id);

    void addReview(Long id, Review review);
}
