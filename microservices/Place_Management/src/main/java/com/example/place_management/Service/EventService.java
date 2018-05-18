package com.example.place_management.Service;

import com.example.place_management.Model.Event;
import com.example.place_management.Model.Place;
import com.example.place_management.Repository.EventRepository;
import com.example.place_management.Repository.PlaceRepository;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public EventService(EventRepository eventRepository, PlaceRepository pr) {
        this.eventRepository = eventRepository;
        this.placeRepository = pr;
    }

    public List<Event> getAll() throws ServiceException {
        try {
            return eventRepository.findAll();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot fetch all events.");
        }
    }

    public Event getById(String id) throws ServiceException {
        try {
            Optional eventHelp = eventRepository.findById(Integer.parseInt(id));
            Event event = (Event) eventHelp.get();
            return event;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find event with id = " + id + ".");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            eventRepository.deleteAll();
            return "All events deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete all events");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            eventRepository.deleteById(Integer.parseInt(id));
            return "Event with id = " + id + " deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete event with id = " + id + ".");
        }
    }

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EventService.class);

    public String postNewEvent(Event event) throws ServiceException {
        log.info(event.toString());
        try {
            Place p = event.getPlace();

            Optional placeHelp = placeRepository.findById(Integer.parseInt((String.valueOf(p.getId()))));

            Place place = (Place) placeHelp.get();


            Event novi = new Event(event.getId(),event.getName(), place);




            eventRepository.save(novi);
            return "Event with name = " + event.getName() + " saved successfully";
        }
        catch (Exception e) {
            log.info(e.getMessage());
            throw new ServiceException("Cannot create event with name = " + event.getName() + ".");
        }
    }

    public String putChangeEvent(Event eventFromRequest) throws ServiceException {
        try {
            Optional eventHelp = eventRepository.findById(eventFromRequest.getId());
            Event event = (Event) eventHelp.get();
            event.setName(eventFromRequest.getName());
            eventRepository.save(event);
            return "Event with id = " + event.getId() + " and name = " + event.getName() + " updated successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update event with id = " + eventFromRequest.getId() + ".");
        }
    }
}