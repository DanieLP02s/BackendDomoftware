package com.domoft.domoftware.Module.Cultivo;

import com.domoft.domoftware.Module.Setting.Fumigacion.Fumigacion;
import com.domoft.domoftware.Module.Setting.Riego.Riego;
import com.domoft.domoftware.Module.Setting.Sensor.Sensor;
import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "cultivo")
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private List<Riego> riegos;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private List<Fumigacion> fumigaciones;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private List<CultivoConfiguration> configurations;

    private String nombreCultivo;

    private String tipoCultivo;

    private String ubicacion;

    private Float area;

    @Column(name = "fecha_plantacion")
    private java.sql.Date fechaPlantacion;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Riego> getRiegos() {
        return riegos;
    }

    public void setRiegos(List<Riego> riegos) {
        this.riegos = riegos;
    }

    public List<Fumigacion> getFumigaciones() {
        return fumigaciones;
    }

    public void setFumigaciones(List<Fumigacion> fumigaciones) {
        this.fumigaciones = fumigaciones;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public List<CultivoConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<CultivoConfiguration> configurations) {
        this.configurations = configurations;
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
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

    public Cultivo(Long id, User user, List<Riego> riegos, List<Fumigacion> fumigaciones, List<Sensor> sensores, List<CultivoConfiguration> configurations, String nombreCultivo, String tipoCultivo, String ubicacion, Float area, Date fechaPlantacion, String descripcion, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.user = user;
        this.riegos = riegos;
        this.fumigaciones = fumigaciones;
        this.sensores = sensores;
        this.configurations = configurations;
        this.nombreCultivo = nombreCultivo;
        this.tipoCultivo = tipoCultivo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.fechaPlantacion = fechaPlantacion;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Cultivo(User user, List<Riego> riegos, List<Fumigacion> fumigaciones, List<Sensor> sensores, List<CultivoConfiguration> configurations, String nombreCultivo, String tipoCultivo, String ubicacion, Float area, Date fechaPlantacion, String descripcion, Timestamp createdAt, Timestamp updatedAt) {
        this.user = user;
        this.riegos = riegos;
        this.fumigaciones = fumigaciones;
        this.sensores = sensores;
        this.configurations = configurations;
        this.nombreCultivo = nombreCultivo;
        this.tipoCultivo = tipoCultivo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.fechaPlantacion = fechaPlantacion;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Cultivo() {
    }
}
