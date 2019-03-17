package com.epam.reviewresource.ReviewResources.handlers;

import com.epam.reviewresource.ReviewResources.exceptions.ReviewNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by saurabh on 17/3/19.
 */
@ControllerAdvice
public class DefaultExceptionHandlerAdvice {

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity handleError(ReviewNotFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());

    }

}
