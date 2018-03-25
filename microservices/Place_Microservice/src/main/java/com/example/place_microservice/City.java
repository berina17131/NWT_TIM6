package com.example.place_microservice;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {
    private int id;
    private String name;
    private Set<Address> addresses;

    protected City() {}

    public City(String name) {
        this.name = name;
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

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        String result = String.format(
                "City[id=%d, name='%s']%n",
                id, name);
        if (addresses != null) {
            for(Address address : addresses) {
                result += String.format(
                        "Address[id=%d, name='%s']%n",
                        address.getId(), address.getName());
            }
        }

        return result;
    }
}