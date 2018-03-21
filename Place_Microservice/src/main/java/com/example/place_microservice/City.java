package com.example.place_microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
   // private Set<Address> addresses;

    protected City() {}

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "City[id=%d, name='%s']",
                id, name);
    }
}