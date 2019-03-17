package com.epam.reviewresource.ReviewResources.service;

import com.epam.reviewresource.ReviewResources.exceptions.ReviewNotFoundException;
import com.epam.reviewresource.ReviewResources.beans.Review;
import com.epam.reviewresource.ReviewResources.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by saurabh on 16/3/19.
 */
@Service
public class ProductsReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    public Review saveReview(Review review) {

        return reviewRepository.save(review);
    }

    public List<Review> getReviews(int productId) {

        List<Review> reviews = reviewRepository.findReviewByProductId(productId);
        if (reviews.isEmpty())
            throw new ReviewNotFoundException("No Review Found with the productId");
        return reviews;

    }

    public Review getReview(int id) {
        Optional<Review> resp = reviewRepository.findById(id);
        if (resp.isPresent()) {
            return resp.get();
        } else {
            throw new ReviewNotFoundException("No Review Found with the Id");
        }


    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Review updateReview(Review review) {
        Optional<Review> reviewFromDb = reviewRepository.findById(review.getId());
        if (reviewFromDb.isPresent()) {
            reviewRepository.deleteById(review.getId());
            reviewRepository.save(review);
        } else
            throw new ReviewNotFoundException("No Review Found with the Id");
        return review;
    }


}
