package com.domoft.domoftware.Module.Cultivo;

import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "cultivo_configuration")
public class CultivoConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cultivoId", referencedColumnName = "id")
    private Cultivo cultivo;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String nombreCultivo;
    private String tipoCultivo;
    private String ubicacion;
    private float area;
    private java.sql.Date fechaPlantacion;
    private String descripcion;

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

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNombreCultivo() {
        return nombreCultivo;
    }

    public void setNombreCultivo(String nombreCultivo) {
        this.nombreCultivo = nombreCultivo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public CultivoConfiguration(Long id, Cultivo cultivo, User user, String nombreCultivo, String tipoCultivo, String ubicacion, float area, Date fechaPlantacion, String descripcion, String schedule, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.cultivo = cultivo;
        this.user = user;
        this.nombreCultivo = nombreCultivo;
        this.tipoCultivo = tipoCultivo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.fechaPlantacion = fechaPlantacion;
        this.descripcion = descripcion;
        this.schedule = schedule;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CultivoConfiguration(Cultivo cultivo, User user, String nombreCultivo, String tipoCultivo, String ubicacion, float area, Date fechaPlantacion, String descripcion, String schedule, Timestamp createdAt, Timestamp updatedAt) {
        this.cultivo = cultivo;
        this.user = user;
        this.nombreCultivo = nombreCultivo;
        this.tipoCultivo = tipoCultivo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.fechaPlantacion = fechaPlantacion;
        this.descripcion = descripcion;
        this.schedule = schedule;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CultivoConfiguration() {
    }

}
