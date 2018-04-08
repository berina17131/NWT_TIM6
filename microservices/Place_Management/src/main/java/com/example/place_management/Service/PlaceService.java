package com.example.place_management.Service;

import com.example.place_management.Model.Place;
import com.example.place_management.Repository.PlaceRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class    PlaceService {

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

    public String deleteAll() throws ServiceException {
        try {
            placeRepository.deleteAll();
            return "All places deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete all places");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            placeRepository.deleteById(Integer.parseInt(id));
            return "Place with id = " + id + " deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete place with id = " + id + ".");
        }
    }

    public String postByName(String name, Optional<String> description) throws ServiceException {
        try {
            Place place;
            if (description.isPresent()) place = new Place(name, description.get());
            else place = new Place(name, "");
            placeRepository.save(place);
            return "Place with name = " + name + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create place with name = " + name + ".");
        }
    }

    public String putById(String id, String newName, Optional<String> description) throws ServiceException {
        try {
            Optional placeHelp = placeRepository.findById(Integer.parseInt(id));
            Place place = (Place) placeHelp.get();
            place.setName(newName);
            if (description.isPresent()) place.setDescription(description.get());
            placeRepository.save(place);
            return "Place with id = " + id + " saved successfully as " + newName;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update place with id = " + id + ".");
        }
    }

    public String putByName(String oldName, String newName, Optional<String> description) throws ServiceException {
        try {
            Place place = null;
            for (Place placeHelp : placeRepository.findAll()) {
                if (placeHelp.getName().equals(oldName))
                    place = placeHelp;
            }
            place.setName(newName);
            if (description.isPresent()) place.setDescription(description.get());
            placeRepository.save(place);
            return "Place with old name = " + oldName + " saved successfully as " + newName;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update place with name = " + oldName + ".");
        }
    }
}