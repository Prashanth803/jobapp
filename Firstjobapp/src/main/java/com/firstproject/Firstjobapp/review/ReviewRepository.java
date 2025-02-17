package com.firstproject.Firstjobapp.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reviewRepository")
public interface ReviewRepository extends JpaRepository<Review,Long>{

    List<Review> findByCompanyId(Long id);
}
