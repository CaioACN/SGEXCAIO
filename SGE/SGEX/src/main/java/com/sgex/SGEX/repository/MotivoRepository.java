package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo, Long> {

    List<Motivo> findAllByTitulo(String titulo);

    @Query("FROM Motivo WHERE titulo LIKE %:titulo")
    List<Motivo> encontrarTodosPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT new com.sgex.SGEX.service.dto.DropDownDTO(r.id,r.titulo) from Motivo  r order by r.titulo asc")
    List<DropDownDTO> getAllMotivoDropDown();
}
