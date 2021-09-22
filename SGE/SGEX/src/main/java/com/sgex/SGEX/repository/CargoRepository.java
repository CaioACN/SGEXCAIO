package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CargoRepository extends JpaRepository<Usuario,Long> {


}
