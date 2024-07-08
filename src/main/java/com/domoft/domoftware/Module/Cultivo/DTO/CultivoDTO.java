package com.domoft.domoftware.Module.Cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CultivoDTO {
    private Long id;
    private String nombreCultivo;
    private String tipoCultivo;
    private String ubicacion;
    private Float area;
    private Date fechaPlantacion;
    private String descripcion;
}
