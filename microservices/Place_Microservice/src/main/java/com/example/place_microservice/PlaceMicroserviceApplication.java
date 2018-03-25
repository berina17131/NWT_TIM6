package com.example.place_microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


@SpringBootApplication
public class PlaceMicroserviceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PlaceMicroserviceApplication.class);

    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(PlaceMicroserviceApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of cities
        City cityA = new City("City A");
        Set addressA = new HashSet<Address>(){{
            add(new Address("Address A1", cityA));
            add(new Address("Address A2", cityA));
            add(new Address("Address A3", cityA));
        }};
        cityA.setAddresses(addressA);

        City cityB = new City("City B");
        Set addressB = new HashSet<Address>(){{
            add(new Address("Address B1", cityB));
            add(new Address("Address B2", cityB));
            add(new Address("Address B3", cityB));
        }};
        cityB.setAddresses(addressB);

        cityRepository.deleteAll();
        cityRepository.save(cityA);
        cityRepository.save(cityB);

        // fetch all categories
        for (City city : cityRepository.findAll()) {
            log.info(city.toString());
        }
    }



/*    @Bean
    public CommandLineRunner demo(CityRepository repository) {
        return (args) -> {
            // save a couple of cities
            City cityA = new City("City A");

            Address a1 = new Address("Address A1", cityA);
            Address a2 = new Address("Address A1", cityA);
            Address a3 = new Address("Address A1", cityA);

            Set addresses = new HashSet<Address>() {{
                add(a1);
                add(a2);
                add(a3);
            }};
            cityA.setAddresses(addresses);

            repository.save(cityA);

            log.info("CITIES:");
            log.info(cityA.toString());
            // fetch all categories
            for (City city : repository.findAll()) {
                log.info(city.toString());
            }
        };
    }
    */
}