package io.watchparty.movie_catalog_service.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.watchparty.movie_catalog_service.DTO.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		return Collections.singletonList(new CatalogItem("Transformers", "Test Description", 4));

	}

}
