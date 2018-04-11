package com.example.interaction_management.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Event {
    private int id;
    @NotNull (message = "Grade cannont be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 char")
    private String name;

    private Set<Grade> grades;
    private Set<Comment> comments;
    private Set<Status> statuses;

    protected Event() {}

    public Event (String title){
        this.name = name;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
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
    }

    @Override
    public String toString() {
        String result = String.format(
                "Event[id=%d, name='%s']%n",
                id, name);
        if (grades != null) {
            for(Grade grade : grades) {
                result += grade.toString();
            }
        }

        if (comments != null) {
            for(Comment comment : comments) {
                result += comment.toString();
            }
        }

        if (statuses != null) {
            for(Status status : statuses) {
                result += status.toString();
            }
        }

        return result;
    }
}
