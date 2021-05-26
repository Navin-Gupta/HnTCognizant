package com.cts.training.micro.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.micro.movieservice.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
