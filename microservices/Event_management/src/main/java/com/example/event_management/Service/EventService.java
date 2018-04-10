package com.example.event_management.Service;

import com.example.event_management.Model.Event;
import com.example.event_management.Repository.EventRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@EnableDiscoveryClient
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
            return null;
        }catch (Exception e) {
            throw new ServiceException("Cannot find place with title={" + title+ "}");
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private EurekaClient discoveryClient;

    public String deleteAll() throws ServiceException {
        try {
            eventRepository.deleteAll();
            // Deleting all events in Place microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("PLACE_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete("http://localhost:" + Integer.toString(instance.getPort()) + "/event/all");

            return "All events deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannon delete all events");
        }

    }

    public String deleteById(String id) throws ServiceException {
        try {
            eventRepository.deleteById(Integer.parseInt(id));
            // Deleting Event with id = @id in Place microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("PLACE_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete("http://localhost:" + Integer.toString(instance.getPort()) + "/event/" + id);
            return "Event with id=" + id + " deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannot delete place with id={" + id + "}");
        }

    }

 public String createEvent(Event event) throws ServiceException {
     try {
         eventRepository.save(event);
         // Creating a event in Place microservice
         InstanceInfo instance = discoveryClient.getNextServerFromEureka("PLACE_MANAGEMENT", false);
         RestTemplate restTemplate = new RestTemplate();
         restTemplate.postForEntity("http://localhost:" + Integer.toString(instance.getPort()) + "/event", event, Event.class);
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
            event.setDescription(eventFromRequest.getDescription());
            eventRepository.save(event);
            // Updating a event in Place microservice
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("PLACE_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put("http://localhost:" + Integer.toString(instance.getPort()) + "/event", event, Event.class);
            return "Event with id = " + event.getId() + " saved successfully as " + event.getName();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update event with id = " + eventFromRequest.getId() + ".");
        }
    }




}
