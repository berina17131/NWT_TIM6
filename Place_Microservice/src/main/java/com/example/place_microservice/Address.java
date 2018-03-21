package com.example.place_microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
//    private City city;
  //  private Set<Place> places;

    protected Address() {}

    public Address(String name) {
        this.name = name;
    }

  /*  public Address(String name, City city) {
        this.name = name;
        this.city = city;
    }
*/
    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, name='%s']",
                id, name);
    }
}