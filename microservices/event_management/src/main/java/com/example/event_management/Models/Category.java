package com.example.event_management.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "category")
public class Category {

    @NotNull
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String description;
    private Set<Event> events;


    public Category() {}

    public Category(String name) {
        this.name = name;
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


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }



}
