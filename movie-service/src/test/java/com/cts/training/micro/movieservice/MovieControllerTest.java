package com.cts.training.micro.movieservice;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.training.micro.movieservice.controller.MovieController;
import com.cts.training.micro.movieservice.entity.Movie;
import com.cts.training.micro.movieservice.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieRepository repository;
	
	@Test
	public void testGetMovieDetails() throws Exception {
		when(this.repository.findById(1)).thenReturn(getMockMovieObject());
		//when(this.repository.findById(1)).thenAnswer(answer)
		RequestBuilder builder = 
				MockMvcRequestBuilders.get("/api/movies/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(builder).andReturn();
		String actualResult = result.getResponse().getContentAsString();
		String expectedResult = asJsonString(getMockMovieObject().get());
		assertEquals(expectedResult, actualResult);
	}
	
	// converting pojo to json string
	public static String asJsonString(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(object);
			return jsonString;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Optional<Movie> getMockMovieObject() {
		Movie movie = new Movie();
		movie.setId(1);
		movie.setMovieName("Dummy");
		movie.setMovieCategory("Action");
		Optional<Movie> record = Optional.of(movie);
		return record;
	}
}
