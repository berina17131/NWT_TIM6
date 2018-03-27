package com.example.event_management.Controller;

import com.example.event_management.Models.Place;
import com.example.event_management.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceRepository placeRepository;

    @Autowired
    PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Place getById(@PathVariable("id") String id) {
        Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
        Place place = (Place) placeHelp.get();

        return place;
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public Place getByName(@PathVariable("name") String name) {
        for (Place place : placeRepository.findAll()) {
            if(place.getName().equals(name))
                return place;
        }

        return null;
    }
}
