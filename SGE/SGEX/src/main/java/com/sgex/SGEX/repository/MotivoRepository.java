package com.sgex.SGEX.repository;

import com.sgex.SGEX.domain.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo,Long> {
}
