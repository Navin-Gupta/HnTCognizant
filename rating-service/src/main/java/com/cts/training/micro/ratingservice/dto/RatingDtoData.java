package com.cts.training.micro.ratingservice.dto;

import java.util.List;

public class RatingDtoData {
	
	// add additional info
	private Integer userId;
	private List<RatingDto> ratingDtos;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<RatingDto> getRatingDtos() {
		return ratingDtos;
	}
	public void setRatingDtos(List<RatingDto> ratingDtos) {
		this.ratingDtos = ratingDtos;
	}
	
	

}
