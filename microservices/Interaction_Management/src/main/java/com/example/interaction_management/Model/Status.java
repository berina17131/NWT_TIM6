package com.example.interaction_management.Model;

import com.sun.istack.internal.NotNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Status {
    private int id;
    private User user;
    private Event event;

    @NotNull
    @Size(min=4, max = 10)
    private String status;

    protected Status() {}

    public Status(String st) {
        this.status = st;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String st) {
        this.status = st;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return String.format(
                "Status[id=%d, status='%s']",
                id, status);
    }
}
