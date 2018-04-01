package com.example.event_management.Controller;

import com.example.event_management.Model.Place;
import com.example.event_management.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private final PlaceRepository placeRepository;

    @Autowired
    PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Place> getAll() {
        return placeRepository.findAll();
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

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAll() {
        placeRepository.deleteAll();

        return "All places deleted";
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        placeRepository.deleteById(Integer.parseInt(id));

        return "Place with id=" + id + " deleted";
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.POST)
    public String postByName(@PathVariable("name") String name) {
        Place place = new Place(name);
        placeRepository.save(place);

        return "City with name " + name + " saved successfully";
    }

    @RequestMapping(value="/id/{id}/newName/{newName}", method = RequestMethod.PUT)
    public String putById(@PathVariable("id") String id, @PathVariable("newName") String newName) {
        Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
        Place place = (Place) placeHelp.get();
        String oldName = place.getName();
        place.setName(newName);
        placeRepository.save(place);

        return "Place with old name " + oldName  + " saved successfully as " + newName;
    }

    @RequestMapping(value="/oldName/{oldName}/newName/{newName}", method = RequestMethod.PUT)
    public String putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
        Place place = null;
        for (Place placeHelp : placeRepository.findAll()) {
            if(placeHelp.getName().equals(oldName))
                place = placeHelp;
        }
        place.setName(newName);
        placeRepository.save(place);

        return "Place with old name " + oldName  + " saved successfully as " + newName;
    }
}
