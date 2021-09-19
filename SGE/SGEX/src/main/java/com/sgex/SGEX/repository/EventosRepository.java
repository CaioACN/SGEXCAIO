package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventosRepository extends JpaRepository <Eventos, Long> {


    @Query("FROM Eventos WHERE patrocinador LIKE %:patrocinador")
    List<Eventos> findAllByPatrocinador(@Param("patrocinador") String patrocinador);

    @Query("SELECT new com.sgex.SGEX.service.dto.DropDownDTO(r.id,r.patrocinador) from Eventos r order by r.patrocinador asc")
    List<DropDownDTO> getAllEventosDropDown();

    Optional<Eventos> findById(Long id);



    Eventos save(Eventos entity);

    void deleteById(Long id);

    List<Eventos> findAll();
}
