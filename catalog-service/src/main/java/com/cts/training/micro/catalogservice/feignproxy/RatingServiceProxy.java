package com.cts.training.micro.catalogservice.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.micro.catalogservice.dto.RatingDtoData;



@FeignClient(name = "rating-service")
public interface RatingServiceProxy {
	@GetMapping("/api/ratings/{userId}")
	public ResponseEntity<RatingDtoData> getRatings(@PathVariable Integer userId);
}
