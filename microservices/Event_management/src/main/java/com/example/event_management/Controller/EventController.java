package com.example.event_management.Controller;

import com.example.event_management.Model.Event;
import com.example.event_management.Service.EventService;
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

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(eventService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.getById(id));

    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByTitle(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(eventService.getByTitle(name));

    }

    @RequestMapping(value="/{category}", method = RequestMethod.GET)
    public ResponseEntity getByCategory(@PathVariable("category") String category) throws ServiceException {
        return ResponseEntity.ok(eventService.getByCategory(category));

    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(eventService.deleteAll());

    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.deleteById(id));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putEvent(@RequestBody Event event) throws ServiceException {
        return ResponseEntity.ok(eventService.putEvent(event));
    }

}
