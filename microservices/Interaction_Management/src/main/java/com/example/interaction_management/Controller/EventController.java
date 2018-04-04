package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Event;
import com.example.interaction_management.Repository.EventRepository;
import com.example.interaction_management.Service.EventService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/event")
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

    @RequestMapping(value="/title/{title}", method = RequestMethod.GET)
    public ResponseEntity getByTitle(@PathVariable("title") String title) throws ServiceException {
        return ResponseEntity.ok(eventService.getByTitle(title));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(eventService.deleteAll());
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(eventService.deleteById(id));
    }

    @RequestMapping(value={"/create/{title}"}, method = RequestMethod.POST)
    public ResponseEntity postByTitle(@PathVariable("title") String title) throws ServiceException {
        return ResponseEntity.ok(eventService.postByTitle(title));
    }

    @RequestMapping(value={"/id/{id}/newTitle/{newTitle}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newTitle") String newTitle) throws ServiceException {
        return ResponseEntity.ok(eventService.putById(id, newTitle));
    }

    @RequestMapping(value={"/oldTitle/{oldTitle}/newTitle/{newTitle}"}, method = RequestMethod.PUT)
    public ResponseEntity putByTitle(@PathVariable("oldTitle") String oldTitle, @PathVariable("newTitle") String newTitle) throws ServiceException {
        return ResponseEntity.ok(eventService.putByTitle(oldTitle, newTitle));
    }
}
