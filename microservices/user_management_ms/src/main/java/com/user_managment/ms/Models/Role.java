package com.user_managment.ms.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Role {

    private int id;

    @NotNull
    @Size(min = 2, max = 10)
    private String role;

    private Set<User> users;

    protected Role() {}

    public Role(String role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user_role", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        String result = String.format("Role[id=%d, role='%s']%n", id, role);
        return result;
    }
}
