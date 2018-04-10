package com.example.place_management.Service;

import com.example.place_management.Model.Event;
import com.example.place_management.Repository.EventRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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

    public String postNewEvent(Event event) throws ServiceException {
        try {
            eventRepository.save(event);
            return "Event with name = " + event.getName() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create event with name = " + event.getName() + ".");
        }
    }

    public String putChangeEvent(Event eventFromRequest) throws ServiceException {
        try {
            Optional eventHelp = eventRepository.findById(eventFromRequest.getId());
            Event event = (Event) eventHelp.get();
            event.setName(eventFromRequest.getName());
            eventRepository.save(event);
            return "Event with id = " + event.getId() + " saved successfully as " + event.getName();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update event with id = " + eventFromRequest.getId() + ".");
        }
    }
}