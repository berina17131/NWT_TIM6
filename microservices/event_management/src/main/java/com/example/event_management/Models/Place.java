package com.example.event_management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "place")
public class Place {

    @NotNull
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    private Event event;

    public Place() {}

    public Place(String name, Event event) {this.name = name; this.event = event;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /* @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
*/

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
