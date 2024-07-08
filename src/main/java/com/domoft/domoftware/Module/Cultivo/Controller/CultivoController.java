package com.domoft.domoftware.Module.Cultivo.Controller;

import com.domoft.domoftware.Module.Cultivo.CultivoDTO;
import com.domoft.domoftware.Module.Cultivo.Services.CultivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
@RequiredArgsConstructor
public class CultivoController {

    private final CultivoService cultivoService;

    // Método para actualizar un cultivo por ID de usuario y ID de cultivo
    @PutMapping("/{userId}/{cultivoId}")
    public ResponseEntity<CultivoDTO> updateCultivo(
            @PathVariable Long userId,
            @PathVariable Long cultivoId,
            @Validated @RequestBody CultivoDTO cultivoDTO) {
        CultivoDTO updatedCultivo = cultivoService.updateCultivo(userId, cultivoId, cultivoDTO);
        return ResponseEntity.ok(updatedCultivo);
    }

    // Otros métodos (creación, obtención y eliminación) ya definidos en tu controlador...

    @PostMapping("/{userId}/crear")
    public ResponseEntity<CultivoDTO> createCultivo(@PathVariable Long userId, @Validated @RequestBody CultivoDTO cultivoDTO) {
        CultivoDTO createdCultivo = cultivoService.createCultivo(userId, cultivoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCultivo);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CultivoDTO>> getCultivosByUserId(@PathVariable Long userId) {
        List<CultivoDTO> cultivos = cultivoService.getCultivosByUserId(userId);
        return ResponseEntity.ok(cultivos);
    }

    @GetMapping("/{userId}/{cultivoId}")
    public ResponseEntity<CultivoDTO> getCultivoByIdAndUserId(@PathVariable Long userId, @PathVariable Long cultivoId) {
        CultivoDTO cultivo = cultivoService.getCultivoByIdAndUserId(cultivoId, userId);
        return ResponseEntity.ok(cultivo);
    }

    @DeleteMapping("/{userId}/{cultivoId}")
    public ResponseEntity<Void> deleteCultivoByIdAndUserId(@PathVariable Long userId, @PathVariable Long cultivoId) {
        cultivoService.deleteCultivoByIdAndUserId(cultivoId, userId);
        return ResponseEntity.noContent().build();
    }
}
