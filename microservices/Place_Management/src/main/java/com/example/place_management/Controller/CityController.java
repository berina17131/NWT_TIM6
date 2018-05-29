package com.example.place_management.Controller;

import com.example.place_management.Model.City;
import com.example.place_management.Service.CityService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(cityService.getAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(cityService.getByName(name));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(cityService.deleteAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(cityService.deleteById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postNewCity(@RequestBody City city) throws ServiceException {
        return ResponseEntity.ok(cityService.postNewCity(city));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeCity(@RequestBody City city) throws ServiceException {
        return ResponseEntity.ok(cityService.putChangeCity(city));
    }
}