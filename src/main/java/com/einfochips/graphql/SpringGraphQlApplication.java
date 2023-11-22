package com.einfochips.graphql;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlApplication.class, args);
	}
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
