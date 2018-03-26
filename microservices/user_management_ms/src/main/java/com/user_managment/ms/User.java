package com.user_managment.ms;

import javax.persistence.*;

@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String ime;
    private String prezime;
    private Role user_role;

    protected User() {}

    public User(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public User(String username, Role user_role) {
        this.username = username;
        this.user_role = user_role;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName="id", nullable=false)
    public Role getUser_role() {
        return user_role;
    }

    public void setUser_role(Role user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, Ime='%s', Prezime='%s', Username='%s']",
                id, ime, prezime, username);
    }

}
