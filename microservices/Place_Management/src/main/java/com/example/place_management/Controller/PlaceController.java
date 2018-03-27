package com.example.place_management.Controller;

import com.example.place_management.Model.Place;
import com.example.place_management.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        placeRepository.deleteById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postById(Place place) {
        placeRepository.save(place);

        return "OK";
    }
}