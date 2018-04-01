package com.example.event_management.Controller;

import com.example.event_management.Model.Event;
import com.example.event_management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Event getById(@PathVariable("id") String id) {
        Optional eventHelp = eventRepository.findById(Integer.parseInt(id));
        Event event = (Event) eventHelp.get();

        return event;
    }

    @RequestMapping(value="/title/{title}", method = RequestMethod.GET)
    public Event getByName(@PathVariable("title") String title) {
        for (Event event : eventRepository.findAll()) {
            if(event.getTitle().equals(title))
                return event;
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postById(Event address) {
        eventRepository.save(address);

        return "OK";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAll() {
        eventRepository.deleteAll();

        return "All events deleted";
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        eventRepository.deleteById(Integer.parseInt(id));

        return "Event with id=" + id + " deleted";
    }

}
