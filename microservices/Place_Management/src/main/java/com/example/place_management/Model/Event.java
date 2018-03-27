package com.example.place_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Event {
    private int id;
    private String name;
    private Place place;

    protected Event() {}

    public Event(String name) {
        this.name = name;
    }

    public Event(String name, Place place) {
        this.name = name;
        this.place = place;
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