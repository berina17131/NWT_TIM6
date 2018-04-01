package com.example.place_management.Controller;

import com.example.place_management.Service.PlaceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(placeService.getAll());

    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(placeService.deleteById(id));

    }

    @RequestMapping(value={"/name/{name}", "/name/{name}/description/{description}"}, method = RequestMethod.POST)
    public ResponseEntity postByName(@PathVariable("name") String name, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(placeService.postByName(name, description));
    }

    @RequestMapping(value={"/id/{id}/newName/{newName}", "/id/{id}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(placeService.putById(id, newName, description));
    }

    @RequestMapping(value={"/oldName/{oldName}/newName/{newName}", "/oldName/{oldName}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(placeService.putByName(oldName, newName, description));
    }
}