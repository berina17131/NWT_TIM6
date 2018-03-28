package com.example.interaction_management.Model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Event {
    private int id;

    @NotNull
    @Size(min = 2, max = 255)
    private String title;

    private Set<Grade> grades;
    private Set<Comment> comments;
    private Set<Status> statuses;

    protected Event() {}

    public Event (String title){
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "Event[id=%d, title='%s']%n",
                id, title);
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
