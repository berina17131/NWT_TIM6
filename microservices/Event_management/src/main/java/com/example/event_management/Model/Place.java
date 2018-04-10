package com.example.event_management.Model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Place {

    private int id;
    @NotNull(message = "Name can not be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    private Set<Event> events;

    public Place() {}

    public Place(String name) {this.name = name;}

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


   @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Place[id=%d, name='%s', description = '%s']%n",
                id, name);
        if (events != null) {
            for(Event event : events) {
                result += event.toString();
            }
        }

        return result;
    }



}
