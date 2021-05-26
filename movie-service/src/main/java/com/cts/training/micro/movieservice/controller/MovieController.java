package com.cts.training.micro.movieservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.micro.movieservice.entity.Movie;
import com.cts.training.micro.movieservice.repository.MovieRepository;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> movieDetails(@PathVariable Integer movieId) {
		Optional<Movie> record = this.repository.findById(movieId);
		Movie movieObj = record.map(movie -> movie).orElse(new Movie());
		
		ResponseEntity<Movie> response = 
				new ResponseEntity<Movie>(movieObj, HttpStatus.OK);
		return response;
	}
	
}
