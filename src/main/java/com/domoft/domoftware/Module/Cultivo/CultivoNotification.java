package com.domoft.domoftware.Module.Cultivo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cultivo_notification")
public class CultivoNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cultivoId", referencedColumnName = "id")
    private Cultivo cultivo;

    private String tipoNotificacion;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private boolean leido;

    private java.sql.Timestamp timestamp;

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

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    //Contractors


    public CultivoNotification(Long id, Cultivo cultivo, String tipoNotificacion, String mensaje, boolean leido, Timestamp timestamp) {
        this.id = id;
        this.cultivo = cultivo;
        this.tipoNotificacion = tipoNotificacion;
        this.mensaje = mensaje;
        this.leido = leido;
        this.timestamp = timestamp;
    }

    public CultivoNotification(Cultivo cultivo, String tipoNotificacion, String mensaje, boolean leido, Timestamp timestamp) {
        this.cultivo = cultivo;
        this.tipoNotificacion = tipoNotificacion;
        this.mensaje = mensaje;
        this.leido = leido;
        this.timestamp = timestamp;
    }

    public CultivoNotification() {
    }

}
