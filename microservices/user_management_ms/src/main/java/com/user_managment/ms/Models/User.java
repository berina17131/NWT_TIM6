package com.user_managment.ms.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    private int id;

    @NotNull
    @Size(min = 4, max = 10)
    private String username;

    @NotNull
    @Size(min = 2)
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 4, max = 10)
    private String ime;

    @Size(min = 4, max = 20)
    private String prezime;

    private Role user_role;

    public User() {
    }

    public User(String ime, String prezime, String username, String password, Role user_role) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.user_role = user_role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "role_id")
    public Role getUser_role() {
        return user_role;
    }

    public void setUser_role(Role user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        String result = String.format(
                "User[id=%d, username='%s', password='%s', email='%s', ime='%s', prezime='%s']%n",
                id, username, password, email, ime, prezime);
        result += user_role.toString();
        return result;
    }

}
