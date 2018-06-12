package com.example.a5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = "com.example.a5")
public class A5restApplication {

	public static void main(String[] args) {
		SpringApplication.run(A5restApplication.class, args);
	}
}
