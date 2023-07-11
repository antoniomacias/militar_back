package com.militar.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication
public class RestFullApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullApiApplication.class, args);
	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {

		http
			.authorizeHttpRequests(authorize -> authorize        
			.requestMatchers("/*").permitAll()                           
				.requestMatchers(HttpMethod.GET, "/getCategories/*", "/usuarios", "/apodo/*", "/perfil/*").permitAll()  
				.anyRequest().denyAll()                                   
			);
		http.httpBasic();
		http.csrf().disable();
		return http.build();

	}
}
