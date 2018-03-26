package com.user_managment.ms;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    private int id;
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

    @OneToMany(mappedBy = "user_role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        String result = String.format("User role[id=%d, name='%s']%n", id, role);
        if(users != null) {
            for(User user : users ) {
                result += String.format(
                        "User[id=%d, username='%s']%n",
                        user.getId(), user.getUsername());
            }
        }
        return result;
    }
}
