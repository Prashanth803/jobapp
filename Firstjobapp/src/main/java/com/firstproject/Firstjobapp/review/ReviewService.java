package com.firstproject.Firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll(Long id);
    boolean addReview(Long id, Review review);
    Review getReview(Long companyId,Long ReviewId);
    boolean updateReview(Long companyId,Long ReviewId,Review review);
    boolean deleteReview(Long companyId,Long reviewId);
}
