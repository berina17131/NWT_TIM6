package com.example.place_management.Service;

import com.example.place_management.Model.Place;
import com.example.place_management.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    public Place getById(String id) {
        Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
        Place place = (Place) placeHelp.get();

        return place;
    }

    public Place getByName(String name) {
        for (Place place : placeRepository.findAll()) {
            if(place.getName().equals(name))
                return place;
        }

        return null;
    }

    public String deleteAll() {
        placeRepository.deleteAll();

        return "All places deleted";
    }

    public String deleteById(String id) {
        placeRepository.deleteById(Integer.parseInt(id));

        return "Place with id=" + id + " deleted";
    }

    public String postByName(String name, Optional<String> description) {
        Place place;
        if (description.isPresent()) place = new Place(name, description.get());
        else place = new Place(name, "");
        placeRepository.save(place);

        return "Place with name " + name + " saved successfully";
    }

    public String putById(String id, String newName, Optional<String> description) {
        Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
        Place place = (Place) placeHelp.get();
        String oldName = place.getName();
        place.setName(newName);
        if (description.isPresent()) place.setDescription(description.get());
        placeRepository.save(place);

        return "Place with old name " + oldName  + " saved successfully as " + newName;
    }

    public String putByName(String oldName, String newName, Optional<String> description) {
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
