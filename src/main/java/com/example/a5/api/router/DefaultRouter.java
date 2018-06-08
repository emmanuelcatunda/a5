package com.example.a5.api.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.a5.api.handler.DefaultHandler;

@Configuration
public class DefaultRouter {

	@Bean
	public RouterFunction<ServerResponse> route(DefaultHandler handler) {

		return RouterFunctions.route(RequestPredicates.GET("/api/version"), handler::getApiVersion);
	}
	
}
