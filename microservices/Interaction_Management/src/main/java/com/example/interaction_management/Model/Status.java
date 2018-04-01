package com.example.interaction_management.Model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Status {
    private int id;
    @NotNull
    @Size(min=4, max = 10)
    private String status;
    private User user;
    private Event event;

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
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
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
