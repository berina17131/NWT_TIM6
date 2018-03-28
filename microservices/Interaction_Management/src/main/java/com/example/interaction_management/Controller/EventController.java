package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Event;
import com.example.interaction_management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Event getById (@RequestParam(value = "id") String id)
    {
        Optional event1 = eventRepository.findById(Integer.parseInt(id));
        Event event = (Event) event1.get();

        return event;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteById (@RequestParam(value = "id") String id)
    {
        try{
            eventRepository.deleteById(Integer.parseInt(id));
            return "Event with id=" + id + " deleted.";
        }
        catch(Exception name) {
            return "Couldn't find event with id=" + id + ".";
        }
    }

    @RequestMapping(value="/title/{title}", method = RequestMethod.POST)
    public String postByTitle (@PathVariable("title") String title) {
        try {
            Event event = new Event(title);
            eventRepository.save(event);

            return "Event created successfully.";
        } catch (Exception ex) {
            return "Error, operation could not be completed.";
        }
    }
}
