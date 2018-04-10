package com.example.place_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event {
    private int id;
    @NotNull(message = "Name cannot be null")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 char")
    private String name;
    private Place place;

    protected Event() {}

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Event(int id, String name, Place place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

    @Id
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "place_id")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Event[id=%d, name='%s']%n",
                id, name);
        return result;
    }
}