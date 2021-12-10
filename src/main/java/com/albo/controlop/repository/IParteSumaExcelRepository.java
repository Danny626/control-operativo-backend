package com.albo.controlop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.model.ParteSumaExcel;

@Repository
public interface IParteSumaExcelRepository extends JpaRepository<ParteSumaExcel, Integer> {

	@Query("FROM ParteSuma ps WHERE ps.parteRecepcion = :parteRecepcion")
	ParteSumaExcel buscarPorParteRecepcion(@Param("parteRecepcion") String parteRecepcion);
	
	@Query("FROM ParteSuma ps WHERE "
			+ "ps.parteRecepcion = :parteRecepcion "
			+ "AND ps.estadoParte = :estadoParte "
			+ "AND ps.fechaRecepcion = :fechaRecepcion "
			+ "AND ps.nroManifiesto = :nroManifiesto "
			+ "AND ps.registroManifiesto = :registroManifiesto "
			+ "AND ps.documentoEmbarque = :documentoEmbarque "
			+ "AND ps.documentoRelacionado = :documentoRelacionado "
			+ "AND ps.placaPatente = :placaPatente")
	ParteSumaExcel buscarPorRegistroRepetido(
			@Param("parteRecepcion") String parteRecepcion,
			@Param("estadoParte") EstadoParte estadoParte,
			@Param("fechaRecepcion") LocalDateTime fechaRecepcion,
			@Param("nroManifiesto") String nroManifiesto,
			@Param("registroManifiesto") String registroManifiesto,
			@Param("documentoEmbarque") String documentoEmbarque,
			@Param("documentoRelacionado") String documentoRelacionado,
			@Param("placaPatente") String placaPatente);
	
	@Query("FROM ParteSuma ps WHERE ps.fechaRecepcion >= :fechaInicial AND ps.fechaRecepcion <= :fechaFinal")
	List<ParteSumaExcel> buscarPorFechaRecepcion(
			@Param("fechaInicial") LocalDateTime fechaInicial,
			@Param("fechaFinal") LocalDateTime fechaFinal);
}
