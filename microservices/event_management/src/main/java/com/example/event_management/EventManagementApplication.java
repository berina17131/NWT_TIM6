package com.example.event_management;

import com.example.event_management.Models.Category;
import com.example.event_management.Models.Event;
import com.example.event_management.Models.Place;
import com.example.event_management.Repository.CategoryRepository;
import com.example.event_management.Repository.EventRepository;
import com.example.event_management.Repository.PlaceRepository;
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
public class EventManagementApplication  implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EventManagementApplication.class);

	@Autowired
	private CategoryRepository categoryRepository;
	private EventRepository eventRepository;
	private PlaceRepository placeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		// save a couple of cities
		Category categoryA = new Category("Category A");




		/*Event eventA = new Event("EeventA","Aaaaaaa", categoryA);
		Event eventB = new Event("EeventB","Bbbbbbb", categoryA);


		Place placeA = new Place("Place A");
		Place placeB = new Place("Place B");

		Set events1 = new HashSet<Event>(){{
			add(eventA);
			add(eventB);
		}};
		categoryA.setEvents(events1);


		Set places1 = new HashSet<Place>(){{
			add(placeA);
		}};

		eventA.setPlaces(places1);

		Set places2 = new HashSet<Place>(){{
			add(placeB);
		}};

		eventB.setPlaces(places2);*/


		//categoryRepository.save(categoryA);
		//placeRepository.save(placeA);
		//placeRepository.save(placeB);
		//eventRepository.save(eventA);

		/*placeA.setEvents(events);

		cityRepository.deleteAll();
		cityRepository.save(cityA);

		//CategoryRepository.save(categoryA);

		/*cityRepository.deleteAll();
		cityRepository.save(cityA);

		// fetch all categories
		for (City city : cityRepository.findAll()) {
			log.info(city.toString());
		}*/
	}
}
