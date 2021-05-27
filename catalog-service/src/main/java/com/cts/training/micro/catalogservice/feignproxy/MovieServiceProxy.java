package com.cts.training.micro.catalogservice.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.micro.catalogservice.dto.Movie;



@FeignClient(name = "movie-service")
public interface MovieServiceProxy {
	@GetMapping("/api/movies/{movieId}")
	public ResponseEntity<Movie> movieDetails(@PathVariable Integer movieId);

}
