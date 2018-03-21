package com.example.place_microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
  //  private Address address;

    protected Place() {}

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }
/*
    public Place(String name, String description, Address address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }
*/
    @Override
    public String toString() {
        return String.format(
                "Place[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}