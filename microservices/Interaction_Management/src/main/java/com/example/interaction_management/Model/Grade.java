package com.example.interaction_management.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Grade {
    private int id;
    @NotNull (message = "Grade cannont be null")
    @Min(value = 1, message = "Grade cannont be lower than 1")
    @Max(value = 5, message = "Grade cannont be higher than 5")
    private int gr;
    private User user;
    private Event event;

    protected Grade() {}

    public Grade(int gr) {
        this.gr = gr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getGr() {
        return this.gr;
    }

    public void setGr(int gr) {
        this.gr = gr;
    }

    @Override
    public String toString() {
        return String.format(
                "Grade[id=%d, grade='%d']",
                id, gr);
    }
}
