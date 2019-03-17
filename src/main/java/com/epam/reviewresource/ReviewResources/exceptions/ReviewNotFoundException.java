package com.epam.reviewresource.ReviewResources.exceptions;

/**
 * Created by saurabh on 17/3/19.
 */
public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String message){
        super(message);
    }

}
