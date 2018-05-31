package com.example.event_management.Controller;

import com.example.event_management.Model.Event;
import com.example.event_management.Service.EventService;
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

    @GetMapping(value = "/name/{name}")
    public ResponseEntity getByTitle(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(eventService.getByTitle(name));

    }

    @GetMapping(value = "/{category}")
    public ResponseEntity getByCategory(@PathVariable("category") String category) throws ServiceException {
        return ResponseEntity.ok(eventService.getByCategory(category));

    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(eventService.deleteAll());

    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.deleteById(id));

    }

    @PostMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity createEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @PutMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.putEvent(event));
    }
}
