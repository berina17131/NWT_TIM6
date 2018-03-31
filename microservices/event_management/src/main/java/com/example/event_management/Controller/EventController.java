package com.example.event_management.Controller;

import com.example.event_management.Model.Event;
import com.example.event_management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private final EventRepository eventRepository;

    @Autowired
    EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Event getById(@PathVariable("id") String id) {
        Optional eventHelp = eventRepository.findById(Integer.parseInt(id));
        Event event = (Event) eventHelp.get();

        return event;
    }

    @RequestMapping(value="/title/{title}", method = RequestMethod.GET)
    public Event getByName(@PathVariable("title") String name) {
        for (Event event : eventRepository.findAll()) {
            if(event.getTitle().equals(event))
                return event;
        }

        return null;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        eventRepository.deleteById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postById(Event address) {
        eventRepository.save(address);

        return "OK";
    }

}
