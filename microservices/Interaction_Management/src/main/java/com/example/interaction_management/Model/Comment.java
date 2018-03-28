package com.example.interaction_management.Model;

import com.sun.istack.internal.NotNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Comment {
    private int id;
    private User user;
    private Event event;

    @NotNull
    @Size(min = 2, max = 255)
    private String comment;

    protected Comment() {}

    public Comment(String co) {
        this.comment = co;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setGrade(String co) {
        this.comment = co;
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
                "Comment[id=%d, comment='%s']",
                id, comment);
    }
}
