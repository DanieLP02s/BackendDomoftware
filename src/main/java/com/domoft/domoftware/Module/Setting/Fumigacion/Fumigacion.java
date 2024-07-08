package com.domoft.domoftware.Module.Setting.Fumigacion;

import com.domoft.domoftware.Module.Cultivo.Cultivo;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "fumigacion")
public class Fumigacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cultivoId", referencedColumnName = "id")
    private Cultivo cultivo;

    private String productoFumigacion;

    @Column(name = "fecha_fumigacion")
    private java.sql.Date fechaFumigacion;

    private Float dosis;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

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

    public String getProductoFumigacion() {
        return productoFumigacion;
    }

    public void setProductoFumigacion(String productoFumigacion) {
        this.productoFumigacion = productoFumigacion;
    }

    public Date getFechaFumigacion() {
        return fechaFumigacion;
    }

    public void setFechaFumigacion(Date fechaFumigacion) {
        this.fechaFumigacion = fechaFumigacion;
    }

    public Float getDosis() {
        return dosis;
    }

    public void setDosis(Float dosis) {
        this.dosis = dosis;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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


    public Fumigacion(Long id, Cultivo cultivo, String productoFumigacion, Date fechaFumigacion, Float dosis, String observaciones, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.cultivo = cultivo;
        this.productoFumigacion = productoFumigacion;
        this.fechaFumigacion = fechaFumigacion;
        this.dosis = dosis;
        this.observaciones = observaciones;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Fumigacion(Cultivo cultivo, String productoFumigacion, Date fechaFumigacion, Float dosis, String observaciones, Timestamp createdAt, Timestamp updatedAt) {
        this.cultivo = cultivo;
        this.productoFumigacion = productoFumigacion;
        this.fechaFumigacion = fechaFumigacion;
        this.dosis = dosis;
        this.observaciones = observaciones;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Fumigacion() {
    }

}

