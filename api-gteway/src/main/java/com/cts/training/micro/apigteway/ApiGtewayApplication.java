package com.cts.training.micro.apigteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGtewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGtewayApplication.class, args);
	}
	
	// explicit mapping
	/*@Bean
	public RouteLocator myCustomRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(myPath -> myPath.path("/get")
			.uri("http://localhost:6060/movie-service/api/movies"))
			.build();

	}*/
	
	@Bean
	public DiscoveryClientRouteDefinitionLocator myDiscoveryRoutes(ReactiveDiscoveryClient client,
																	DiscoveryLocatorProperties props) {
		return new DiscoveryClientRouteDefinitionLocator(client, props);
	}

}
