package com.embarkx.firstjobapp.Review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
@GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(Long companyId) {

        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review)
    {
        reviewService.addReview(companyId,review);
        return new  ResponseEntity<>("Review Added Sucessfully", HttpStatus.OK);
    }
}
