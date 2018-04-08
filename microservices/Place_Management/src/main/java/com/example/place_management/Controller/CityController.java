package com.example.place_management.Controller;

import com.example.place_management.Service.CityService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(cityService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(cityService.getByName(name));
    }

    @RequestMapping(value="/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(cityService.deleteAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(cityService.deleteById(id));
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.POST)
    public ResponseEntity postByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(cityService.postByName(name));
    }
    
    @RequestMapping(value="/id/{id}/newName/{newName}", method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(cityService.putById(id, newName));
    }

    @RequestMapping(value="/oldName/{oldName}/newName/{newName}", method = RequestMethod.PUT)
    public ResponseEntity putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(cityService.putByName(oldName, newName));
    }
}