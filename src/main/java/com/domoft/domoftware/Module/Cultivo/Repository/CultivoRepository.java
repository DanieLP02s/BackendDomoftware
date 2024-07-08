package com.domoft.domoftware.Module.Cultivo.Repository;

import com.domoft.domoftware.Module.Cultivo.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
    Optional<Cultivo> findByIdAndUser_Id(Long cultivoId, Long userId);
    void deleteByIdAndUser_Id(Long cultivoId, Long userId);
    List<Cultivo> findByUser_Id(Long userId);
}
