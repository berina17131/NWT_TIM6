package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Event;
import com.example.interaction_management.Repository.EventRepository;
import com.netflix.appinfo.InstanceInfo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll() throws ServiceException {
        try {
            return eventRepository.findAll();
        }catch (Exception e) {
            throw new ServiceException("Cannot fetch all events.");
        }
    }

    public Event getById(String id) throws ServiceException {
        try {
            Optional eventHelp = eventRepository.findById(Integer.parseInt(id));
            Event event = (Event) eventHelp.get();

            return event;
        }catch (Exception e) {
            throw new ServiceException("Cannot find event with id={" + id + "}");
        }
    }

    public Event getByTitle(String title) throws ServiceException {
        try {
            for (Event event : eventRepository.findAll()) {
                if (event.getName().equals(title))
                    return event;
            }
            throw new ServiceException("Cannot find place with title={" + title+ "}");
        }catch (Exception e) {
            throw new ServiceException("Cannot find place with title={" + title+ "}");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            eventRepository.deleteAll();
            return "All events deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannon delete all events");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            eventRepository.deleteById(Integer.parseInt(id));
            return "event with id=" + id + " deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannot delete place with id={" + id + "}");
        }
    }


    public String createEvent(Event event) throws ServiceException {
        try {
            Event ev = new Event(event.getId(), event.getName());
;                    System.out.println(ev.toString());
            eventRepository.save(ev);

            return "Event with name = " + event.getName() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create event with name = " + event.getName() + ".");
        }
    }

    public String putEvent(Event eventFromRequest) throws ServiceException {
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
