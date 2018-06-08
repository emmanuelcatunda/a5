package com.example.a5rest.api.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class DefaultHandler {

	@Value("${api.version}")
	private String apiVersion;

	public Mono<ServerResponse> getApiVersion(ServerRequest request) {

		return ServerResponse.ok().body(fromObject(ApiResponse.builder().addEntry("version", apiVersion).build()));

	}

}
