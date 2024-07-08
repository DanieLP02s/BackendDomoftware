package com.domoft.domoftware.Module.Cultivo;

import com.domoft.domoftware.Module.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cultivo")
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Otros atributos de Cultivo
    private String nombreCultivo;
    private String tipoCultivo;
    private String ubicacion;
    private Float area;

    @Column(name = "fecha_plantacion")
    private Date fechaPlantacion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    private Timestamp updatedAt;
}
