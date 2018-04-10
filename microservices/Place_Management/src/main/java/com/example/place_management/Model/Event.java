package com.example.place_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event {
    private int id;
    @NotNull
    @Size(min=2, max=50)
    private String title;
    private Place place;

    protected Event() {}

    public Event(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Event(int id, String title, Place place) {
        this.id = id;
        this.title = title;
        this.place = place;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "Event[id=%d, title='%s']%n",
                id, title);
        return result;
    }
}