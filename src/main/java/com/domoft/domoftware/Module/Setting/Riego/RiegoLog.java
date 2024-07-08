package com.domoft.domoftware.Module.Setting.Riego;

import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "riego_log")
public class RiegoLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "riegoId", referencedColumnName = "id")
    private Riego riego;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private java.sql.Timestamp timestamp;

    private String action;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Riego getRiego() {
        return riego;
    }

    public void setRiego(Riego riego) {
        this.riego = riego;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    //Contractor

    public RiegoLog(Long id, Riego riego, User user, Timestamp timestamp, String action) {
        this.id = id;
        this.riego = riego;
        this.user = user;
        this.timestamp = timestamp;
        this.action = action;
    }

    public RiegoLog(Riego riego, User user, Timestamp timestamp, String action) {
        this.riego = riego;
        this.user = user;
        this.timestamp = timestamp;
        this.action = action;
    }

    public RiegoLog() {
    }

}
