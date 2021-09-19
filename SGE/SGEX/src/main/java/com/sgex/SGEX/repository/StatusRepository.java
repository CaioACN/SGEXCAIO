package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Cargo;
import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.domain.Status;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAllByDescricacao(String descricacao);

    @Query("FROM Status  WHERE descricacao LIKE %:descricacao")
    List<Status> encontrarTodosPorDescricao(@Param("descricao") String descricacao);

    @Query("SELECT new com.sgex.SGEX.service.dto.DropDownDTO(r.id,r.descricao) from Status r order by r.descricao asc")
    List<DropDownDTO> getAllStatusDropDown();
}
