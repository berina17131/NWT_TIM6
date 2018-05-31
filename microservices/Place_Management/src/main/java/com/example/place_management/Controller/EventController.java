package com.example.place_management.Controller;

import com.example.place_management.Model.Event;
import com.example.place_management.Service.EventService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(eventService.getAll());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.getById(id));
    }

    @DeleteMapping(value = "/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(eventService.deleteAll());
    }

    @DeleteMapping(value = "/id/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.deleteById(id));
    }

    @PostMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity postNewEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.postNewEvent(event));
    }

    @PutMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putChangeEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.putChangeEvent(event));
    }
}
