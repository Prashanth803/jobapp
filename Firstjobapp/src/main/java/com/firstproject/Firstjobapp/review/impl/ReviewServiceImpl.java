package com.firstproject.Firstjobapp.review.impl;

import com.firstproject.Firstjobapp.company.Company;
import com.firstproject.Firstjobapp.company.CompanyReposirory;
import com.firstproject.Firstjobapp.company.CompanyService;
import com.firstproject.Firstjobapp.review.Review;
import com.firstproject.Firstjobapp.review.ReviewRepository;
import com.firstproject.Firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewServiceImpl implements ReviewService {
    private CompanyService companyService;
    private ReviewRepository reviewRepository;
    private CompanyReposirory companyReposirory;
    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyReposirory companyReposirory,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyReposirory=companyReposirory;
        this.companyService =companyService;
    }

    @Override
    public List<Review> findAll(Long id) {
        return reviewRepository.findByCompanyId(id);
    }

    @Override
    public boolean addReview(Long id, Review review) {
        Company company=companyReposirory.findById(id).orElse(null);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long ReviewId) {
        List<Review>reviews=reviewRepository.findByCompanyId(companyId);
        return reviews.stream().
                filter(review->review.getId().equals(ReviewId)).
                findFirst().
                orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long ReviewId, Review review) {
        Company company=companyReposirory.findById(companyId).orElse(null);
        if(company!=null) {
            review.setId(ReviewId);
            review.setCompany(company);
            review.setTitle(review.getTitle());
            review.setDescription(review.getDescription());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanybyId(companyId)!=null && reviewRepository.existsById(reviewId)){
         Review review=reviewRepository.findById(reviewId).orElse(null);
         Company company=review.getCompany();
         List<Review>reviews=company.getReviews();
         reviews.remove(review);
         companyService.updateCompany(companyId,company);
         reviewRepository.deleteById(reviewId);
         return true;
        }
        return false;
    }

}
