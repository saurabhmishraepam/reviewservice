package com.epam.reviewresource.ReviewResources.controllers;

import com.epam.reviewresource.ReviewResources.beans.Review;
import com.epam.reviewresource.ReviewResources.service.ProductsReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saurabh on 16/3/19.
 */
@Controller
@RequestMapping("/reviews")
public class ProductsReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ProductsReviewController.class);

    @Autowired
    private ProductsReviewService productsReviewService;

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity getReviews(@PathVariable("productId") int productId) {
        logger.info("ProductId :: " + productId);
        List<Review> reviews = productsReviewService.getReviews(productId);
        return ResponseEntity.ok(reviews);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity getReview(@PathVariable("id") int id) {
        logger.info("id :: " + id);
        Review review = productsReviewService.getReview(id);
        return ResponseEntity.ok(review);

    }

    @PostMapping
    public ResponseEntity createReviews(@RequestBody Review review) {
        logger.info(review.toString());
        Review result = productsReviewService.saveReview(review);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity updateReviews(@RequestBody Review review) {
        logger.info(review.toString());
        Review reviewU= productsReviewService.updateReview(review);
        return ResponseEntity.ok(reviewU);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(@PathVariable("id") int id) {
        logger.info(" deleting review by id",id);
        productsReviewService.deleteReview(id);
        return ResponseEntity.accepted().build();
    }


}
