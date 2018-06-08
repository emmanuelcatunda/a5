package com.example.a5rest;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.a5.api.ApiResponse;
import com.example.a5.api.handler.DefaultHandler;
import com.example.a5.api.router.DefaultRouter;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DefaultRouter.class, DefaultHandler.class })
@WebFluxTest()
public class DefaultTests {

	@Autowired
	ApplicationContext context;

	@Value("${api.version}")
	private String apiVersion;

	@Autowired
	WebTestClient webClient;

	@Before
	public void setup() {
		webClient = WebTestClient.bindToApplicationContext(context).configureClient().build();

	}

	@Test
	@SuppressWarnings("unlikely-arg-type")
	public void testVersion() throws JSONException {

		ApiResponse apiResponse = ApiResponse.builder().addEntry("version", apiVersion).build();

		this.webClient.get().uri("/api/version").accept(MediaType.APPLICATION_STREAM_JSON).exchange().expectStatus().isOk().expectBody().equals(apiResponse.toString());

	}
}
