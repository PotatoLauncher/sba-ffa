package com.mazio.freeForAllApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class FreeForAllAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeForAllAppApplication.class, args);
	}

}
