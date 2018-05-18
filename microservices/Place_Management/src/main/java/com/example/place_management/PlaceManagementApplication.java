package com.example.place_management;

import com.example.place_management.Model.Address;
import com.example.place_management.Model.City;
import com.example.place_management.Model.Place;
import com.example.place_management.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
public class PlaceManagementApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlaceManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		// save a couple of cities
		City cityA = new City("Sarajevo");
		City cityB = new City("Zenica");
		City cityC = new City("Tuzla");

		Address addressA = new Address("Vilsonovo šetalište 8", cityA);
		Address addressB = new Address("Mehmeda Spahe 20", cityA);
		Address addressC = new Address("Kamberovića čikma 10", cityB);

		Set addresses = new HashSet<Address>() {{
			add(addressA);
			add(addressB);
		}};
		cityA.setAddresses(addresses);
		addresses = new HashSet<Address>() {{
			add(addressC);
		}};
		cityB.setAddresses(addresses);

		Place placeA = new Place("My Face", "Mjesto najbolje zabave u gradu", addressA);
		Place placeB = new Place("Sloga", "Zabava vikendom zagarantovana", addressB);
		Place placeC = new Place("Shopping centar", "Mjesto dobre kupovine", addressC);

		Set places = new HashSet<Place>(){{
			add(placeA);
		}};
		addressA.setPlaces(places);
		places = new HashSet<Place>(){{
			add(placeB);
		}};
		addressB.setPlaces(places);
		places = new HashSet<Place>(){{
			add(placeC);
		}};
		addressC.setPlaces(places);

		cityRepository.deleteAll();
		cityRepository.save(cityA);
		cityRepository.save(cityB);
		cityRepository.save(cityC);
	}
}