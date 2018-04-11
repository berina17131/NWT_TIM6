package com.example.place_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Address {

    private int id;
    @NotNull(message = "Name can not be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @JsonIgnoreProperties("addresses")
    private City city;
    @JsonIgnoreProperties("address")
    private Set<Place> places;

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

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Address[id=%d, name='%s']%n",
                id, name);
        if (places != null) {
            for(Place place : places) {
                result += place.toString();
            }
        }

        return result;
    }
}