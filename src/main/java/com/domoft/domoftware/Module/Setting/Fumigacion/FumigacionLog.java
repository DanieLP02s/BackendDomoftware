package com.domoft.domoftware.Module.Setting.Fumigacion;

import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "fumigacion_log")
public class FumigacionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fumigacionId", referencedColumnName = "id")
    private Fumigacion fumigacion;

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

    public Fumigacion getFumigacion() {
        return fumigacion;
    }

    public void setFumigacion(Fumigacion fumigacion) {
        this.fumigacion = fumigacion;
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

    //Contractors


    public FumigacionLog(Long id, Fumigacion fumigacion, User user, Timestamp timestamp, String action) {
        this.id = id;
        this.fumigacion = fumigacion;
        this.user = user;
        this.timestamp = timestamp;
        this.action = action;
    }

    public FumigacionLog(Fumigacion fumigacion, User user, Timestamp timestamp, String action) {
        this.fumigacion = fumigacion;
        this.user = user;
        this.timestamp = timestamp;
        this.action = action;
    }

    public FumigacionLog() {
    }

}
