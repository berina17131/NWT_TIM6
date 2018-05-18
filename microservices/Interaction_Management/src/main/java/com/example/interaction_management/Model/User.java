package com.example.interaction_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    private int id;
    @NotNull(message = "Username cannont be null")
    @Size(min = 4, max = 10, message = "Username must be between 4 and 10 char")
    private String username;

    @JsonIgnoreProperties("user")
    private Set<Grade> grades;

    @JsonIgnoreProperties("user")
    private Set<Comment> comments;

    @JsonIgnoreProperties("user")
    private Set<Status> statuses;

    protected User() {}

    public User (String username){
        this.username = username;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        String result = String.format(
                "User[id=%d, username='%s']%n",
                id, username);
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
