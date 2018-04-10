package com.example.place_management;

import com.example.place_management.Model.Address;
import com.example.place_management.Model.City;
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

		cityRepository.deleteAll();
		cityRepository.save(cityA);
		cityRepository.save(cityB);
		cityRepository.save(cityC);
	}
}