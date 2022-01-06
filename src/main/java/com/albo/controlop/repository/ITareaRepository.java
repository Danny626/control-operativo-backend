package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.Tarea;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {

	@Query("FROM Tarea t WHERE t.recinto.recCod = :codRecinto AND t.tipo = :tipo")
	Tarea buscarPorNombre(
		@Param("codRecinto") String codRecinto,
		@Param("tipo") String tipo
	);

}
