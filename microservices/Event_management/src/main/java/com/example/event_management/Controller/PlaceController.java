package com.example.event_management.Controller;

import com.example.event_management.Model.Place;
import com.example.event_management.Repository.PlaceRepository;
import com.example.event_management.Service.PlaceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value={"/name/{name}"}, method = RequestMethod.POST)
    public ResponseEntity postByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(placeService.postByName(name));
    }

    @RequestMapping(value={"/id/{id}/newName/{newName}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(placeService.putById(id, newName));
    }

    @RequestMapping(value={"/oldName/{oldName}/newName/{newName}"}, method = RequestMethod.PUT)
    public ResponseEntity putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(placeService.putByName(oldName, newName));
    }
}
