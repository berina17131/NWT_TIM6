package com.example.place_management;

import com.example.place_management.Model.Address;
import com.example.place_management.Model.City;
import com.example.place_management.Model.Event;
import com.example.place_management.Model.Place;
import com.example.place_management.Repository.CityRepository;
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
public class PlaceManagementApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(PlaceManagementApplication.class);

	@Autowired
	private CityRepository cityRepository;


	public static void main(String[] args) {
		SpringApplication.run(PlaceManagementApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		// save a couple of cities
		City cityA = new City("City A");

		Address addressA = new Address("Address A", cityA);
		Address addressB = new Address("Address B", cityA);

		Set addresses = new HashSet<Address>(){{
			add(addressA);
			add(addressB);
		}};
		cityA.setAddresses(addresses);

		Place placeA = new Place("Place A", "Prvo mjesto", addressA);
		Place placeB = new Place("Place B", "Drugo mjesto", addressB);

		Set places = new HashSet<Place>(){{
			add(placeA);
		}};
		addressA.setPlaces(places);
		places = new HashSet<Place>(){{
			add(placeB);
		}};
		addressB.setPlaces(places);

		Event eventA = new Event("Event A", placeA);
		Set events = new HashSet<Event>(){{
			add(eventA);
		}};
		placeA.setEvents(events);

		cityRepository.deleteAll();
		cityRepository.save(cityA);

		// fetch all categories
		for (City city : cityRepository.findAll()) {
			log.info(city.toString());
		}
	}
}