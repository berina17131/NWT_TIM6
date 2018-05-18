package com.example.event_management;

import com.example.event_management.Model.Category;
import com.example.event_management.Repository.CategoryRepository;
import com.example.event_management.Repository.EventRepository;
import com.example.event_management.Repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan({"com.example.event_management"})
@EntityScan("com.example.event_management.Model")
@EnableJpaRepositories("com.example.event_management.Repository")
@SpringBootApplication
@EnableDiscoveryClient
public class EventManagementApplication implements CommandLineRunner {


	private static final Logger log = LoggerFactory.getLogger(EventManagementApplication.class);

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private EventRepository eventRepository;


	public static void main(String[] args) {



		SpringApplication.run(EventManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		Category categoryB = new Category("Category123","aaaaa");
    Category categoryA = new Category("CategoryAA","");
    categoryRepository.save(categoryA);
/*
    Place placeA = new Place("placeeAA");
    placeRepository.save(placeA);


    Event eventA = new Event("Zabava1","Najbolja1", categoryA, placeA);
    eventRepository.save(eventA);
		Event eventB = new Event("Zabava22","Naj", categoryA, placeA);
		eventRepository.save(eventB);
		Event eventC = new Event("Zabava333","Na1", categoryA, placeA);
		eventRepository.save(eventC);
		Event eventD = new Event("Zabava444","NaAAAAAAAAAA1", categoryA, placeA);
		eventRepository.save(eventD);*/
	}

}



