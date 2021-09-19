package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.domain.Usuario;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByNome(String nome);

    @Query("FROM Usuario  WHERE nome LIKE %:nome")
    List<Usuario> encontrarTodosPorNome(@Param("nome") String nome);

    @Query("SELECT new com.sgex.SGEX.service.dto.DropDownDTO(r.id,r.nome) from Usuario  r order by r.nome asc")
    List<DropDownDTO> getAllUsuarioDropDown();



    Optional<Usuario> findById(Long id);


    List<Usuario> findAllByNome();

    Usuario save(Usuario entity);

    void deleteById(long id);
}
