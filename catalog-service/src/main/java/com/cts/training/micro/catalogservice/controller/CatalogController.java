package com.cts.training.micro.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.training.micro.catalogservice.dto.Catalog;
import com.cts.training.micro.catalogservice.dto.CatalogDtoData;
import com.cts.training.micro.catalogservice.dto.Movie;
import com.cts.training.micro.catalogservice.dto.RatingDto;
import com.cts.training.micro.catalogservice.dto.RatingDtoData;
import com.cts.training.micro.catalogservice.feignproxy.MovieServiceProxy;
import com.cts.training.micro.catalogservice.feignproxy.RatingServiceProxy;

@RestController
@RequestMapping("/api")
public class CatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieServiceProxy movieProxy;
	
	@Autowired
	private RatingServiceProxy ratingProxy;
	
	
	// private final String RATING_SERVICE_URL = "http://localhost:5050/rating-service/api/ratings";
	// private final String MOVIE_SERVICE_URL = "http://localhost:6060/movie-service/api/movies";
	
	private final String RATING_SERVICE_URL = "http://RATING-SERVICE/api/ratings";
    private final String MOVIE_SERVICE_URL = "http://MOVIE-SERVICE/api/movies";
	
	@GetMapping("/catalog/{userId}")
	public ResponseEntity<CatalogDtoData> getCatalog(@PathVariable Integer userId) {
		
		// 1. sent a request to rating service
		RatingDtoData ratingDtoData = this.restTemplate.getForObject(this.RATING_SERVICE_URL + "/" + userId, RatingDtoData.class);
		
		// 2. sent request to movie service
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		for(RatingDto ratingDto : ratingDtoData.getRatingDtos()) {
			Integer movieId = ratingDto.getMovieId();
			Movie movie = this.restTemplate.getForObject(this.MOVIE_SERVICE_URL + "/" + movieId, Movie.class);
			
			// club the info in Catalog(aggregation)
			Catalog catalog = new Catalog(movieId, 
										  movie.getMovieName(), 
										  movie.getMovieCategory(), 
										  ratingDto.getRating());
			catalogs.add(catalog);
		}
		
		CatalogDtoData catalogDtoData = new CatalogDtoData();
		catalogDtoData.setCatalogs(catalogs);
		catalogDtoData.setUserId(userId);
		
		ResponseEntity<CatalogDtoData> response = 
				new ResponseEntity<CatalogDtoData>(catalogDtoData, HttpStatus.OK);
		
		return response;
	}
	
	
	@GetMapping("/catalog-feign/{userId}")
	public ResponseEntity<CatalogDtoData> getCatalogFeign(@PathVariable Integer userId) {
		
		// 1. sent a request to rating service
		ResponseEntity<RatingDtoData> ratingResponse = this.ratingProxy.getRatings(userId); 
		
		RatingDtoData ratingDtoData = ratingResponse.getBody();
		// 2. sent request to movie service
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		for(RatingDto ratingDto : ratingDtoData.getRatingDtos()) {
			Integer movieId = ratingDto.getMovieId();
			ResponseEntity<Movie> movieResponse = this.movieProxy.movieDetails(movieId);
			Movie movie = movieResponse.getBody();
			// club the info in Catalog(aggregation)
			Catalog catalog = new Catalog(movieId, 
										  movie.getMovieName(), 
										  movie.getMovieCategory(), 
										  ratingDto.getRating());
			catalogs.add(catalog);
		}
		
		CatalogDtoData catalogDtoData = new CatalogDtoData();
		catalogDtoData.setCatalogs(catalogs);
		catalogDtoData.setUserId(userId);
		
		ResponseEntity<CatalogDtoData> response = 
				new ResponseEntity<CatalogDtoData>(catalogDtoData, HttpStatus.OK);
		
		return response;
	}
}
