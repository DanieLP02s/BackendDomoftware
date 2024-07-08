package com.domoft.domoftware.Module.Setting.Riego;

import com.domoft.domoftware.Module.Cultivo.Cultivo;
import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "riego")
public class Riego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cultivoId", referencedColumnName = "id")
    private Cultivo cultivo;

    private String tipoRiego;

    private Integer frecuencia;

    private Integer duracion;

    @Column(name = "hora_inicio")
    private java.sql.Time horaInicio;

    @Column(name = "hora_fin")
    private java.sql.Time horaFin;

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

    public String getTipoRiego() {
        return tipoRiego;
    }

    public void setTipoRiego(String tipoRiego) {
        this.tipoRiego = tipoRiego;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
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


    public Riego(Long id, Cultivo cultivo, String tipoRiego, Integer frecuencia, Integer duracion, Time horaInicio, Time horaFin, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.cultivo = cultivo;
        this.tipoRiego = tipoRiego;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Riego(Cultivo cultivo, String tipoRiego, Integer frecuencia, Integer duracion, Time horaInicio, Time horaFin, Timestamp createdAt, Timestamp updatedAt) {
        this.cultivo = cultivo;
        this.tipoRiego = tipoRiego;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Riego() {
    }

}
