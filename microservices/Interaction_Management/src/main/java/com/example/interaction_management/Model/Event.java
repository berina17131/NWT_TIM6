package com.example.interaction_management.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Event {
    private int id;
    @NotNull(message = "Name can not be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 char")
    private String name;

    @JsonIgnoreProperties("event")
    private Set<Grade> grades;

    @JsonIgnoreProperties("event")
    private Set<Comment> comments;

    @JsonIgnoreProperties("event")
    private Set<Status> statuses;

    protected Event() {
    }

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }*/

    @Override
    public String toString() {
        String result = String.format(
                "Event[id=%d, name='%s']%n",
                id, name);

        return result;
    }
}
