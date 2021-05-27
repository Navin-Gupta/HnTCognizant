package com.cts.training.micro.catalogservice.dto;

public class Catalog {

	private Integer movieId;
	
	// private MovieDto movieDto;
	private String movieName;
	private String movieCategory;
	
	private Integer rating;
	
	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Catalog(Integer movieId, String movieName, String movieCategory, Integer rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieCategory = movieCategory;
		this.rating = rating;
	}




	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
