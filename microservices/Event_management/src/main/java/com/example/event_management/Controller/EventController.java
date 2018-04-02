package com.example.event_management.Controller;

import com.example.event_management.Model.Event;
import com.example.event_management.Model.Place;
import com.example.event_management.Repository.EventRepository;
import com.example.event_management.Service.EventService;
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

    @RequestMapping(value={"/create/{title}", "/create/{title}/{description}"}, method = RequestMethod.POST)
    public ResponseEntity postByTitle(@PathVariable("title") String title, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(eventService.postByTitle(title, description));
    }

    @RequestMapping(value={"/id/{id}/newTitle/{newTitle}", "/id/{id}/newTitle/{newTitle}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newTitle") String newTitle, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(eventService.putById(id, newTitle, description));
    }

    @RequestMapping(value={"/oldTitle/{oldTitle}/newTitle/{newTitle}", "/oldTitle/{oldTitle}/newTitle/{newTitle}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putByTitle(@PathVariable("oldTitle") String oldTitle, @PathVariable("newTitle") String newTitle, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(eventService.putByTitle(oldTitle, newTitle, description));
    }

}
