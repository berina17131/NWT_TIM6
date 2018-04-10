package com.example.event_management.Controller;

import com.example.event_management.Model.Place;
import com.example.event_management.Repository.PlaceRepository;
import com.example.event_management.Service.PlaceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(placeService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(placeService.getById(id));

    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(placeService.getByName(name));

    }

    @RequestMapping(value="/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(placeService.deleteAll());

    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(placeService.deleteById(id));

    }
/*
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postNewPlace(@RequestBody Place place) throws ServiceException {
        return ResponseEntity.ok(placeService.createPlace(place));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangePlace(@RequestBody Place place) throws ServiceException {
        return ResponseEntity.ok(placeService.putPlace(place));
    }*/
}
