package com.cts.training.micro.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.micro.ratingservice.dto.RatingDto;
import com.cts.training.micro.ratingservice.repository.RatingRepository;

@RestController
@RequestMapping("/api")
public class RatingController {
	
	@Autowired
	private RatingRepository repository;
	
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<List<RatingDto>> getRatings(@PathVariable Integer userId){
		
	}
}
