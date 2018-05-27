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

import java.util.*;

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

    public List<Event> getByCategory(String category) throws ServiceException {
        try {
            List<Event> events =  eventRepository.findAll();
            Set<Event> eventsSet = new HashSet<>();

            for(Event e: events)
            {
                if(e.getCategory().getName().equals(category))
                {
                    eventsSet.add(e);
                }
            }

            return new ArrayList<>(eventsSet);
        }catch (Exception e) {
            throw new ServiceException("Cannot fetch all events.");
        }
    }

    public List<Event> getByTitle(String title) throws ServiceException {
        try {
            List<Event> events =  eventRepository.findAll();
            Set<Event> eventsSet = new HashSet<>();
            boolean exist = false;

            for (Event event : events) {
                if (event.getName().equals(title)) {
                    eventsSet.add(event);
                    exist = true;
                }
            }

            if(exist == false)
               return null;
            else
                return new ArrayList<>(eventsSet);
        }catch (Exception e) {
            throw new ServiceException("Cannot find event with title={" + title+ "}");
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

            // Deleting all events in Interaction microservice
            InstanceInfo instance1 = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
            RestTemplate restTemplate1 = new RestTemplate();
            restTemplate1.delete("http://localhost:" + Integer.toString(instance1.getPort()) + "/event/all");

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

            // Deleting Event with id = @id in Interaction microservice
            InstanceInfo instance1 = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
            RestTemplate restTemplate1 = new RestTemplate();
            restTemplate1.delete("http://localhost:" + Integer.toString(instance1.getPort()) + "/event/" + id);


            return "Event with id=" + id + " deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannot delete event with id={" + id + "}");
        }

    }

 public String createEvent(Event event) throws ServiceException {
     try {
         eventRepository.save(event);
        /// Creating a event in Place microservice
        /* InstanceInfo instance = discoveryClient.getNextServerFromEureka("PLACE_MANAGEMENT", false);
         RestTemplate restTemplate = new RestTemplate();
         restTemplate.postForEntity("http://localhost:" + Integer.toString(instance.getPort()) + "/event", event, null);
*/
         // Creating a event in Interaction microservice
        // log.info("");
         System.out.println("PRVI");
        InstanceInfo instance1 = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
         RestTemplate restTemplate1 = new RestTemplate();
         restTemplate1.postForEntity("http://localhost:" + Integer.toString(instance1.getPort()) + "/event", event, null);


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
            restTemplate.put("http://localhost:" + Integer.toString(instance.getPort()) + "/event", event);

            // Updating a event in Interaction microservice
            InstanceInfo instance1 = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
            RestTemplate restTemplate1 = new RestTemplate();
            restTemplate1.put("http://localhost:" + Integer.toString(instance1.getPort()) + "/event", event);


            return "Event with id = " + event.getId() + " saved successfully as " + event.getName();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update event with id = " + eventFromRequest.getId() + ".");
        }
    }




}
