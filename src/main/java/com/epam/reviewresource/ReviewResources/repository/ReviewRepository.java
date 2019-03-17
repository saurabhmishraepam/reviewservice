package com.epam.reviewresource.ReviewResources.repository;

import com.epam.reviewresource.ReviewResources.beans.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by saurabh on 16/3/19.
 */
public interface ReviewRepository extends MongoRepository< Review, Integer> {

    public List<Review> findReviewByProductId(int productId);
}