package com.domoft.domoftware.Module.User;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_activity_log")
public class UserActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String action;

    private java.sql.Timestamp timestamp;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Contractor

    public UserActivityLog(Long id, User user, String action, Timestamp timestamp, String description) {
        this.id = id;
        this.user = user;
        this.action = action;
        this.timestamp = timestamp;
        this.description = description;
    }

    public UserActivityLog(User user, String action, Timestamp timestamp, String description) {
        this.user = user;
        this.action = action;
        this.timestamp = timestamp;
        this.description = description;
    }

    public UserActivityLog() {
    }

}

