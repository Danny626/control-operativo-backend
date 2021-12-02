package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.DestinatarioParte;

@Repository
public interface IDestinatarioParteRepository extends JpaRepository<DestinatarioParte, Integer> {

	@Query("FROM DestinatarioParte dp WHERE dp.nombre = :destinatario")
	DestinatarioParte buscarPorNombre(@Param("destinatario") String destinatario);

}
