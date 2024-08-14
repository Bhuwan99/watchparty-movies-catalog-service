package io.watchparty.movie_catalog_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import io.watchparty.movie_catalog_service.DTO.CatalogItem;
import io.watchparty.movie_catalog_service.DTO.Movie;
import io.watchparty.movie_catalog_service.DTO.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	@Autowired 
	private RestClient.Builder restClientBuilder;
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		//get movie ids rated by user using ratings-info-service
		UserRating ratings = restClientBuilder.build().get()
				.uri("http://ratings-data-service/ratingsdata/users/{userId}", userId)
				.retrieve()
				.body(UserRating.class)
				;
				
		//for each rating, take movie id and return details using movie info service
		return ratings.getUserRating().stream()
				.map(rating -> {
					Movie movie = restClientBuilder.build().get()
					.uri("http://movies-info-service/movies/{movieId}", rating.getMovieId()) // calling the movies-info service
					.retrieve()
					.body(Movie.class);
					return new CatalogItem(movie.getName(), "desc", rating.getRating());

		}).toList();
	}

}
