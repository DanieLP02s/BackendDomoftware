package com.domoft.domoftware.Module.Setting.Sensor;

import com.domoft.domoftware.Module.Cultivo.Cultivo;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cultivoId", referencedColumnName = "id")
    private Cultivo cultivo;

    private String tipoSensor;

    private String ubicacion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    private Timestamp updatedAt;

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

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    //Contractor

    public Sensor(Long id, Cultivo cultivo, String tipoSensor, String ubicacion, String descripcion, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.cultivo = cultivo;
        this.tipoSensor = tipoSensor;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Sensor(Cultivo cultivo, String tipoSensor, String ubicacion, String descripcion, Timestamp createdAt, Timestamp updatedAt) {
        this.cultivo = cultivo;
        this.tipoSensor = tipoSensor;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Sensor() {
    }

}
