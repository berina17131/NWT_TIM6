package com.example.event_management;

import com.example.event_management.Models.Category;
import com.example.event_management.Models.Event;
import com.example.event_management.Models.Place;
import com.example.event_management.Repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EventManagementApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EventManagementApplication.class);

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		// save a couple of cities
		Category categoryA = new Category("Category A");

		Place placeA = new Place("Place A");
		Place placeB = new Place("Place B");


		Event eventA = new Event("EeventA","Aaaaaaa", categoryA, placeA);
		Event eventB = new Event("EeventB","Bbbbbbb", categoryA, placeB);
		Event eventC = new Event("EeventC","Ccccccc", categoryA, placeA);
		Event eventD = new Event("EeventD","Ddddddd", categoryA, placeB);

		Set events1 = new HashSet<Event>(){{
			add(eventA);
			add(eventC);
		}};
		placeA.setEvents(events1);

		Set events2 = new HashSet<Event>(){{
			add(eventB);
			add(eventD);
		}};

		placeB.setEvents(events2);

		Set eventsCategory = new HashSet<Event>(){{
			add(eventA);
			add(eventC);
			add(eventB);
			add(eventD);
		}};

		categoryA.setEvents(eventsCategory);

		/*cityRepository.deleteAll();
		cityRepository.save(cityA);

		// fetch all categories
		for (City city : cityRepository.findAll()) {
			log.info(city.toString());
		}*/
	}
}
