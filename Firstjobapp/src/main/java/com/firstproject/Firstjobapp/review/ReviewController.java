package com.firstproject.Firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{id}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findReview(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.findAll(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long id, @RequestBody Review review){
        if(reviewService.addReview(id,review))return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
        else return new ResponseEntity<>("NOT found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{Id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id,@PathVariable Long Id){
        Review review=reviewService.getReview(id,Id);
        if(review!=null)return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{Id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id,@PathVariable Long Id,@RequestBody Review review){
        if(reviewService.updateReview(id,Id,review))return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);
        return new ResponseEntity<>("NOT found",HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/reviews/{Id}")
        public ResponseEntity<String> deleteReview(@PathVariable Long id,@PathVariable Long Id){
    if(reviewService.deleteReview(id,Id))return new ResponseEntity<>("Deleted",HttpStatus.OK);
    return new ResponseEntity<>("NOT found",HttpStatus.NOT_FOUND);

    }

}
