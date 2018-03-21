package com.user_managment.ms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String ime;
    private String prezime;

    protected User() {}

    public User(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, Ime='%s', Prezime='%s']",
                id, ime, prezime);
    }

}
