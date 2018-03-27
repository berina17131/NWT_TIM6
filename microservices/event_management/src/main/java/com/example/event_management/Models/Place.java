package com.example.event_management.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {

    private int id;
    private String name;
    private Set<Event> events;

    public Place() {}

    public Place(String name) {this.name = name;}

    @Id
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



}
