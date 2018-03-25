package com.example.place_microservice;

import javax.persistence.*;

@Entity
public class Address {
    private int id;
    private String name;
    private City city;
  //  private Set<Place> places;

    protected Address() {}

    public Address(String name) {
        this.name = name;
    }

    public Address(String name, City city) {
        this.name = name;
        this.city = city;
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
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, name='%s']",
                id, name);
    }
}