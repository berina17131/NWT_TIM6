package com.example.place_microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlaceMicroserviceApplication {

	private static final Logger log = LoggerFactory.getLogger(PlaceMicroserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlaceMicroserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CityRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new City("Sarajevo"));
			repository.save(new City("Zenica"));

			// fetch all cities
			log.info("Cities found with findAll():");
			log.info("-------------------------------");
			for (City city : repository.findAll()) {
				log.info(city.toString());
			}
			log.info("");
	};
	}
}