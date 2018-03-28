package com.example.interaction_management.Model;

import com.sun.istack.internal.NotNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Grade {
    private int id;
    private User user;
    private Event event;

    @NotNull
    @Min(1)
    @Max(5)
    private int grade;

    protected Grade() {}

    public Grade(int gr) {
        this.grade = gr;
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

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int gr) {
        this.grade = gr;
    }

    @Override
    public String toString() {
        return String.format(
                "Grade[id=%d, grade='%d']",
                id, grade);
    }
}
