package io.watchparty.movie_catalog_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {
	@Bean
	@LoadBalanced
	public RestClient.Builder getRestClient() {
		return RestClient.builder();
	}

}
