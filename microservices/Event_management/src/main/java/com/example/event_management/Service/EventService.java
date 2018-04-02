package com.example.event_management.Service;

import com.example.event_management.Model.Event;
import com.example.event_management.Repository.EventRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                if (event.getTitle().equals(title))
                    return event;
            }
            return null;
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

    public String postByTitle(String title, Optional<String> description) throws ServiceException {
        try {
            Event event;
            if (description.isPresent()) event = new Event(title, description.get());
            else event = new Event(title, "");
            eventRepository.save(event);

            return "event with title " + title + " saved successfully";
        }catch (Exception e) {
            throw new ServiceException("Cannot save place with title={" + title + "}");
        }
    }

    public String putById(String id, String newTitle, Optional<String> description) throws ServiceException {
        try {
            Optional eventHelp = eventRepository.findById(Integer.parseInt(id));
            Event event = (Event) eventHelp.get();
            String oldTitle = event.getTitle();
            event.setTitle(newTitle);
            if (description.isPresent()) event.setDescription(description.get());
            eventRepository.save(event);

            return "Event with old title " + oldTitle + " saved successfully as " + newTitle;
        }catch (Exception e) {
            throw new ServiceException("Cannot change event.");
        }
    }

    public String putByTitle(String oldTitle, String newTitle, Optional<String> description) throws ServiceException {
        try {
            Event event = null;
            for (Event eventHelp : eventRepository.findAll()) {
                if (eventHelp.getTitle().equals(oldTitle))
                    event = eventHelp;
            }
            event.setTitle(newTitle);
            if (description.isPresent()) event.setDescription(description.get());
            eventRepository.save(event);

            return "event with old title " + oldTitle + " saved successfully as " + newTitle;
        }catch (Exception e) {
            throw new ServiceException("Cannot change event.");
        }
    }





}
