package com.example.event_management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;


@Entity(name = "event")
public class Event {

    @NotNull
    private int id;

    @NotNull
    @Size(min=2, max=30)
    private String title;

    private String description;
    private Category category;
    private Set<Place> places;

    public Event() {}

    public Event(String title, String description, Category category)
    {
        this.title = title;
        this.description = description;
        this.category = category;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    /*@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "place_id")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }*/

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




    @Override
    public String toString() {
        return String.format(
                "Event[id=%d, title='%s']",
                id, title);
    }

}