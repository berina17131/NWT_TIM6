package com.example.place_management.Controller;

import com.example.place_management.Model.Place;
import com.example.place_management.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

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

    @RequestMapping(value={"/name/{name}", "/name/{name}/description/{description}"}, method = RequestMethod.POST)
    public String postByName(@PathVariable("name") String name, @PathVariable("description") Optional<String> description) {
        Place place;
        if (description.isPresent()) place = new Place(name, description.get());
        else place = new Place(name, "");
        placeRepository.save(place);

        return "Place with name " + name + " saved successfully";
    }

    @RequestMapping(value={"/id/{id}/newName/{newName}", "/id/{id}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public String putById(@PathVariable("id") String id, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) {
        Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
        Place place = (Place) placeHelp.get();
        String oldName = place.getName();
        place.setName(newName);
        if (description.isPresent()) place.setDescription(description.get());
        placeRepository.save(place);

        return "Place with old name " + oldName  + " saved successfully as " + newName;
    }

    @RequestMapping(value={"/oldName/{oldName}/newName/{newName}", "/oldName/{oldName}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public String putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) {
        Place place = null;
        for (Place placeHelp : placeRepository.findAll()) {
            if(placeHelp.getName().equals(oldName))
                place = placeHelp;
        }
        place.setName(newName);
        if (description.isPresent()) place.setDescription(description.get());
        placeRepository.save(place);

        return "Place with old name " + oldName  + " saved successfully as " + newName;
    }
}