package com.example.place_management.Controller;

import com.example.place_management.Model.Event;
import com.example.place_management.Service.EventService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(eventService.getAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.getById(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(eventService.deleteAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.deleteById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postNewEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.postNewEvent(event));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.putChangeEvent(event));
    }
}