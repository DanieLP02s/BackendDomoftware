package com.domoft.domoftware.Module.Cultivo.Services;

import com.domoft.domoftware.Module.Cultivo.Cultivo;
import com.domoft.domoftware.Module.Cultivo.CultivoDTO;
import com.domoft.domoftware.Module.Cultivo.Repository.CultivoRepository;
import com.domoft.domoftware.Module.User.User;
import com.domoft.domoftware.Module.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CultivoService {

    private final CultivoRepository cultivoRepository;
    private final UserRepository userRepository;

    public CultivoDTO createCultivo(Long userId, CultivoDTO cultivoDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + userId));

        Cultivo cultivo = Cultivo.builder()
                .user(user)
                .nombreCultivo(cultivoDTO.getNombreCultivo())
                .tipoCultivo(cultivoDTO.getTipoCultivo())
                .ubicacion(cultivoDTO.getUbicacion())
                .area(cultivoDTO.getArea())
                .fechaPlantacion(cultivoDTO.getFechaPlantacion())
                .descripcion(cultivoDTO.getDescripcion())
                .createdAt(new Timestamp(new Date().getTime()))
                .build();

        Cultivo savedCultivo = cultivoRepository.save(cultivo);

        return CultivoDTO.builder()
                .id(savedCultivo.getId())
                .nombreCultivo(savedCultivo.getNombreCultivo())
                .tipoCultivo(savedCultivo.getTipoCultivo())
                .ubicacion(savedCultivo.getUbicacion())
                .area(savedCultivo.getArea())
                .fechaPlantacion(savedCultivo.getFechaPlantacion())
                .descripcion(savedCultivo.getDescripcion())
                .build();
    }

    public CultivoDTO getCultivoByIdAndUserId(Long cultivoId, Long userId) {
        Cultivo cultivo = cultivoRepository.findByIdAndUser_Id(cultivoId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Cultivo no encontrado para el usuario con ID " + userId + " y cultivo ID " + cultivoId));

        return CultivoDTO.builder()
                .id(cultivo.getId())
                .nombreCultivo(cultivo.getNombreCultivo())
                .tipoCultivo(cultivo.getTipoCultivo())
                .ubicacion(cultivo.getUbicacion())
                .area(cultivo.getArea())
                .fechaPlantacion(cultivo.getFechaPlantacion())
                .descripcion(cultivo.getDescripcion())
                .build();
    }

    public void deleteCultivoByIdAndUserId(Long cultivoId, Long userId) {
        cultivoRepository.deleteByIdAndUser_Id(cultivoId, userId);
    }

    public List<CultivoDTO> getCultivosByUserId(Long userId) {
        List<Cultivo> cultivos = cultivoRepository.findByUser_Id(userId);

        // Convertir a DTOs
        return cultivos.stream()
                .map(cultivo -> CultivoDTO.builder()
                        .id(cultivo.getId())
                        .nombreCultivo(cultivo.getNombreCultivo())
                        .tipoCultivo(cultivo.getTipoCultivo())
                        .ubicacion(cultivo.getUbicacion())
                        .area(cultivo.getArea())
                        .fechaPlantacion(cultivo.getFechaPlantacion())
                        .descripcion(cultivo.getDescripcion())
                        .build())
                .toList();
    }

    public CultivoDTO updateCultivo(Long userId, Long cultivoId, CultivoDTO cultivoDTO) {
        Cultivo cultivo = cultivoRepository.findByIdAndUser_Id(cultivoId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Cultivo no encontrado para el usuario con ID " + userId + " y cultivo ID " + cultivoId));

        cultivo.setNombreCultivo(cultivoDTO.getNombreCultivo());
        cultivo.setTipoCultivo(cultivoDTO.getTipoCultivo());
        cultivo.setUbicacion(cultivoDTO.getUbicacion());
        cultivo.setArea(cultivoDTO.getArea());
        cultivo.setFechaPlantacion(cultivoDTO.getFechaPlantacion());
        cultivo.setDescripcion(cultivoDTO.getDescripcion());

        Cultivo updatedCultivo = cultivoRepository.save(cultivo);

        return CultivoDTO.builder()
                .id(updatedCultivo.getId())
                .nombreCultivo(updatedCultivo.getNombreCultivo())
                .tipoCultivo(updatedCultivo.getTipoCultivo())
                .ubicacion(updatedCultivo.getUbicacion())
                .area(updatedCultivo.getArea())
                .fechaPlantacion(updatedCultivo.getFechaPlantacion())
                .descripcion(updatedCultivo.getDescripcion())
                .build();
    }
}
