package com.cts.training.micro.ratingservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cts.training.micro.ratingservice.entity.Rating;

public class RatingRepositoryCustomImpl implements RatingRepositoryCustom {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Rating> someVeryComplexRequirement() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
