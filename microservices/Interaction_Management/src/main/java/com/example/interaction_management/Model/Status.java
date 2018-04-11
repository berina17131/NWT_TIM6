package com.example.interaction_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Status {
    private int id;
    @NotNull(message = "Status cannont be null")
    @Size(min=4, max = 10, message = "Status must be between 4 and 10 char")
    private String status;
    @JsonIgnoreProperties("statuses")
    private User user;
    @JsonIgnoreProperties("statuses")
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

    public String getSt() {
        return this.status;
    }

    public void setSt(String st) {
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
