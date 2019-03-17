package com.epam.reviewresource.ReviewResources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReviewResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewResourcesApplication.class, args);
	}

}
