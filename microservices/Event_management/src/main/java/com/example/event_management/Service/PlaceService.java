package com.example.event_management.Service;

import com.example.event_management.Model.Place;
import com.example.event_management.Repository.PlaceRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAll() throws ServiceException {
       try
       {
           return placeRepository.findAll();
       } catch (Exception e) {
           throw new ServiceException("Cannot fetch all places.");
       }
    }

    public Place getById(String id) throws ServiceException {
        try {
            Optional placeHelp = placeRepository.findById(Integer.parseInt(id));

            Place place = (Place) placeHelp.get();

            return place;
        }catch (Exception e) {
            throw new ServiceException("Cannot find place with id={" + id + "}");
        }
    }

    public Place getByName(String name) throws ServiceException {
       try
       {
           for (Place place : placeRepository.findAll()) {
               if (place.getName().equals(name))
                   return place;
           }
           return null;

       } catch (Exception e) {
           throw new ServiceException("Cannot find place with name={" + name + "}");
       }
    }

    public String deleteAll() throws ServiceException {
        try {
            placeRepository.deleteAll();

            return "All places deleted";
        }catch(Exception e) {
            throw new ServiceException("Cannon delete all users");
        }

    }

    public String deleteById(String id) throws ServiceException {
        try {
            placeRepository.deleteById(Integer.parseInt(id));

            return "Place with id=" + id + " deleted";
        }catch (Exception e) {
            throw new ServiceException("Cannot delete place with id={" + id + "}");
        }
    }





}
