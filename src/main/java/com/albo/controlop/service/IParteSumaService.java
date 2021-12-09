package com.albo.controlop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.model.ParteSumaExcel;

public interface IParteSumaService extends IService<ParteSumaExcel, Integer> {

	ParteSumaExcel buscarPorParteRecepcion(String parteRecepcion);
	
	ParteSumaExcel buscarPorRegistroRepetido(
			String parteRecepcion, EstadoParte estadoParte,
			LocalDateTime fechaRecepcion, String nroManifiesto,	String registroManifiesto,
			String documentoEmbarque, String documentoRelacionado, String placaPatente);
	
	List<ParteSumaExcel> buscarPorFechaRecepcion(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
