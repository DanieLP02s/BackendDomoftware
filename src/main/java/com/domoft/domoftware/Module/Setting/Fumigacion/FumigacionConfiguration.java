package com.domoft.domoftware.Module.Setting.Fumigacion;

import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "fumigacion_configuration")
public class FumigacionConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fumigacionId", referencedColumnName = "id")
    private Fumigacion fumigacion;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;

    private String description;

    @Column(columnDefinition = "JSON")
    private String schedule;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    //Contractors


    public FumigacionConfiguration(Long id, Fumigacion fumigacion, User user, String name, String description, String schedule, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.fumigacion = fumigacion;
        this.user = user;
        this.name = name;
        this.description = description;
        this.schedule = schedule;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public FumigacionConfiguration(Fumigacion fumigacion, User user, String name, String description, String schedule, Timestamp createdAt, Timestamp updatedAt) {
        this.fumigacion = fumigacion;
        this.user = user;
        this.name = name;
        this.description = description;
        this.schedule = schedule;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public FumigacionConfiguration() {
    }

}
