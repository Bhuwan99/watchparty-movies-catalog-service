package io.watchparty.movie_catalog_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {
	
	private String name;
	private String description;
	private int rating;

}
