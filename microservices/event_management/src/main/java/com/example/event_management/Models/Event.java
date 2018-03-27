package com.example.event_management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Event {

    private int id;
    private String title;
    private String description;
    private Category category;
    private Place place;

    public Event() {}

    public Event(String title, String description, Category category, Place place)
    {
        this.title = title;
        this.description = description;
        this.category = category;
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "place_id")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

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
                "Address[id=%d, title='%s']",
                id, title);
    }

}