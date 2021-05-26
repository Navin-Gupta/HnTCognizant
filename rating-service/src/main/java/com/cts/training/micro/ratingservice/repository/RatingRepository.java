package com.cts.training.micro.ratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.micro.ratingservice.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{

}
