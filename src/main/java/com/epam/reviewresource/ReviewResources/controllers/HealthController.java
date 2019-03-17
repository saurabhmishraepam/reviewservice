package com.epam.reviewresource.ReviewResources.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saurabh on 17/3/19.
 */
@RequestMapping("/")
public class HealthController {

    @Autowired
    private UserDetailsService userDetailsService;
    @GetMapping
    public ResponseEntity checkResponse(Authentication auth){
        System.out.println("calling");
        return ResponseEntity.ok("OKKKK");
    }
}
