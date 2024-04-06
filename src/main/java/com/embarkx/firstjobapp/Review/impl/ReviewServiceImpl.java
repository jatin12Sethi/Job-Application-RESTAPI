package com.embarkx.firstjobapp.Review.impl;
import com.embarkx.firstjobapp.Company.Company;
import com.embarkx.firstjobapp.Company.CompanyService;
import com.embarkx.firstjobapp.Review.Review;
import com.embarkx.firstjobapp.Review.ReviewRepository;
import com.embarkx.firstjobapp.Review.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long id) {
        return reviewRepository.findByCompanyId(id);

    }
    @Override
    public void addReview(Long id, Review review) {
        Company company = companyService.getCompanyById(id);
        if(company != null){
            review.setCompany(company);
             reviewRepository.save(review);
        }
    }
}
