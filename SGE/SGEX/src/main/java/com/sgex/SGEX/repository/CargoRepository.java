package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Cargo;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    List<Cargo> findAllByDescricao(String descricao);

    @Query("FROM Cargo WHERE descricao LIKE %:descricao")
    List<Cargo> encontrarTodosPorDescricao(@Param("descricao") String descricacao);

    @Query("SELECT new com.sgex.SGEX.service.dto.DropDownDTO(r.id,r.descricao) from Cargo r order by r.descricao asc")
    List<DropDownDTO> getAllCargoDropDown();
}
