package com.cts.training.micro.ratingservice.dto;

public class RatingDto {

	private Integer movieId;
	private Integer rating;
	
	public RatingDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RatingDto(Integer movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}



	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
