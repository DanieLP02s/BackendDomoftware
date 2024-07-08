package com.domoft.domoftware.Module.User;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_notification")
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String type;

    @Column(columnDefinition = "TEXT")
    private String message;

    private boolean isRead;

    private java.sql.Timestamp timestamp;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    //Contractor

    public UserNotification(Long id, User user, String type, String message, boolean isRead, Timestamp timestamp) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.message = message;
        this.isRead = isRead;
        this.timestamp = timestamp;
    }

    public UserNotification(User user, String type, String message, boolean isRead, Timestamp timestamp) {
        this.user = user;
        this.type = type;
        this.message = message;
        this.isRead = isRead;
        this.timestamp = timestamp;
    }

    public UserNotification() {
    }

}