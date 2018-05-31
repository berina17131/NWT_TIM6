package com.example.event_management.Controller;

import com.example.event_management.Model.Place;
import com.example.event_management.Service.PlaceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "*")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(placeService.getAll());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(placeService.getById(id));

    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(placeService.getByName(name));

    }

    @DeleteMapping(value = "/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(placeService.deleteAll());

    }

    @DeleteMapping(value = "/id/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(placeService.deleteById(id));

    }

    @PostMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity postNewPlace(@RequestBody Place place) throws ServiceException {
        return ResponseEntity.ok(placeService.createPlace(place));
    }

    @PutMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putChangePlace(@RequestBody Place place) throws ServiceException {
        return ResponseEntity.ok(placeService.putPlace(place));
    }
}
