package com.cts.training.micro.ratingservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.micro.ratingservice.dto.RatingDto;
import com.cts.training.micro.ratingservice.dto.RatingDtoData;
import com.cts.training.micro.ratingservice.entity.Rating;
import com.cts.training.micro.ratingservice.repository.RatingRepository;

@RestController
@RequestMapping("/api")
public class RatingController {
	
	@Autowired
	private RatingRepository repository;
	
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<RatingDtoData> getRatings(@PathVariable Integer userId){
		
		List<Rating> ratings = this.repository.findAll();
		// List<Rating> ratings= this.repository.findRatingsByUserId(userId);
		
		// convert into dto listing
		List<RatingDto> ratingDtos = ratings.stream()
						.map(rating -> {
							RatingDto ratingDto = new RatingDto(rating.getMovieId(), rating.getRating());
							return ratingDto;
									
						})
						.collect(Collectors.toList());
	
		// encapsulate inside RatingDtoData
		RatingDtoData ratingDtoData = new RatingDtoData();
		ratingDtoData.setRatingDtos(ratingDtos);
		ratingDtoData.setUserId(userId);
		
		
		ResponseEntity<RatingDtoData> response = 
				new ResponseEntity<RatingDtoData>(ratingDtoData, HttpStatus.OK);
		return response;
	}
}
