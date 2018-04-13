package com.example.place_management.Service;

import com.example.place_management.Model.Place;
import com.example.place_management.Repository.PlaceRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@EnableDiscoveryClient
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAll() throws ServiceException {
        try {
            return placeRepository.findAll();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot fetch all places.");
        }
    }

    public Place getById(String id) throws ServiceException {
        try {
            Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
            Place place = (Place) placeHelp.get();
            return place;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find place with id = " + id + ".");
        }
    }

    public Place getByName(String name) throws ServiceException {
        try {
            for (Place place : placeRepository.findAll()) {
                if (place.getName().equals(name))
                    return place;
            }
            // In case it did not find a place with given name
            throw new Exception();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find place with name = " + name + ".");
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private EurekaClient discoveryClient;

    public String deleteAll() throws ServiceException {
        try {
            placeRepository.deleteAll();
            // Deleting all places in Event microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("EVENT_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete("http://localhost:" + Integer.toString(instance.getPort()) + "/place/all");
            return "All places deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete all places");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            placeRepository.deleteById(Integer.parseInt(id));
            // Deleting place with id = @id in Event microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("EVENT_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete("http://localhost:" + Integer.toString(instance.getPort()) + "/place/" + id);
            return "Place with id = " + id + " deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete place with id = " + id + ".");
        }
    }

    public String postNewPlace(Place place) throws ServiceException {
        try {
            placeRepository.save(place);
            // Creating a place in Event microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("EVENT_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity("http://localhost:" + Integer.toString(instance.getPort()) + "/place", place, null);
            return "Place with name = " + place.getName() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create place with name = " + place.getName() + ".");
        }
    }

    public String putChangePlace(Place placeFromRequest) throws ServiceException {
        try {
            Optional placeHelp = placeRepository.findById(placeFromRequest.getId());
            Place place = (Place) placeHelp.get();
            place.setName(placeFromRequest.getName());
            place.setDescription(placeFromRequest.getDescription());
            placeRepository.save(place);
            // Updating a place in Event microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("EVENT_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put("http://localhost:" + Integer.toString(instance.getPort()) + "/place", place);
            return "Place with id = " + place.getId() + " and name = " + place.getName() + " updated successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update place with id = " + placeFromRequest.getId() + ".");
        }
    }
}