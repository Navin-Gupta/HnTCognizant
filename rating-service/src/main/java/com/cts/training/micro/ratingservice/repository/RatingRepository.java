package com.cts.training.micro.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.training.micro.ratingservice.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>, RatingRepositoryCustom{
	
	List<Rating> findRatingsByUserId(Integer userId);
	
	// JPQL 
	@Query("select r from Rating r where r.userId = :userId and r.movieId = :movieId")
	Rating getRatingsOnSpecificRequirement(@Param("userId")Integer userId, @Param("movieId")Integer movieId);
}
