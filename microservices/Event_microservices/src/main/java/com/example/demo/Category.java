package com.example.demo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Set<Event> events;

    public Category(){}

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    public Set<Event> getEvents() {
        return events;
    }



}
