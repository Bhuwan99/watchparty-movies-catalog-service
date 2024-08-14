package io.watchparty.movie_catalog_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
	private String movieId;
	private String name;

}
