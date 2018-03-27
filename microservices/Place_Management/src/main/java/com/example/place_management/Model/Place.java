package com.example.place_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Place {
    private int id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String description;
    private Address address;
    private Set<Event> events;

    protected Place() {}

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Place(String name, String description, Address address) {
            this.name = name;
            this.description = description;
            this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Place[id=%d, name='%s', description = '%s']%n",
                id, name, description);
        if (events != null) {
            for(Event event : events) {
                result += event.toString();
            }
        }

        return result;
    }
}