package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Category category = null;
    private Timestamp date = null;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    public Category getBookCategory() {
        return category;
    }

    public Event() {}

    public Event(String a, String b) {
        this.title = a;
        this.description = b;


    }

}
